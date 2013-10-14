package net.nan21.dnet.module.ad.business.ext.scheduler.delegate;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.BeansException;

import net.nan21.dnet.core.api.Constants;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.job.IScheduler;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.core.scheduler.JobDetailBase;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContextParam;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;

public class JobScheduler_Bd extends AbstractBusinessDelegate {

	/**
	 * Delete Quartz jobs associated with the {@link JobContext} entities
	 * identified by the list of ids.
	 * 
	 * @param jobContextIds
	 * @throws BusinessException
	 */
	public void removeQuartzJob(List<Object> jobContextIds)
			throws BusinessException {
		List<JobKey> jobKeys = new ArrayList<JobKey>();
		String clientId = Session.user.get().getClientId();
		for (Object id : jobContextIds) {
			jobKeys.add(new JobKey((String) id, clientId));
		}
		Scheduler quartzScheduler = this.getQuartzScheduler();
		try {
			quartzScheduler.deleteJobs(jobKeys);
		} catch (SchedulerException exc) {
			throw new BusinessException("Cannot delete quartz jobs.", exc);
		}
	}

	/**
	 * Create Quartz jobs for a list of {@link JobContext} entities.
	 * 
	 * @param list
	 * @throws BusinessException
	 */
	public void createQuartzJob(List<JobContext> list) throws BusinessException {

		Scheduler quartzScheduler = this.getQuartzScheduler();
		for (JobContext e : list) {
			JobDetail jobDetail = newJob(JobDetailBase.class)
					.withIdentity(e.getId().toString(),
							e.getClientId().toString()).storeDurably().build();
			jobDetail.getJobDataMap().put(Constants.QUARTZ_JOB_NAME,
					e.getJobName());

			List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>();
			String dateFormatMasks = Constants.get_server_alt_formats();
			String[] t = dateFormatMasks.split(";");
			for (int i = 0, len = t.length; i < len; i++) {
				dateFormats.add(new SimpleDateFormat(t[i]));
			}

			for (JobContextParam jcp : e.getParams()) {
				String name = jcp.getParamName();
				String value = jcp.getValue();
				String dataType = jcp.getDataType();

				Object v = value;
				if (value != null && !"".equals(value)) {
//					if ("java.lang.String".equals(dataType)) {
//
//					} else if ("java.lang.Integer".equals(dataType)
//							|| "int".equals(dataType)) {
//						v = Integer.parseInt(value);
//					} else if ("java.lang.Long".equals(dataType)
//							|| "long".equals(dataType)) {
//						v = Long.parseLong(value);
//					} else if ("java.lang.Boolean".equals(dataType)
//							|| "boolean".equals(dataType)) {
//						v = Boolean.valueOf(value);
//					} else 
						if ("java.util.Date".equals(dataType)) {
						boolean ok = false;
						for (SimpleDateFormat df : dateFormats) {
							try {
								v = df.parse(value);
								ok = true;
								break;
							} catch (Exception exc) {
								// ignore and try the next one
							}
						}
						if (!ok) {
							throw new IllegalArgumentException(
									"Date value ["
											+ value
											+ "] doesn't match any of the expected formats:  ["
											+ dateFormatMasks + "]");
						}
					}
				}

				jobDetail.getJobDataMap().put(name, v);
			}

			try {
				quartzScheduler.addJob(jobDetail, true);
			} catch (Exception exc) {
				throw new BusinessException(
						"Cannot add job to quartz scheduler.", exc);
			}
		}
	}

	/**
	 * Delete Quartz triggers associated with the {@link JobTimer} entities
	 * identified by the list of ids.
	 * 
	 * @param jobTimerIds
	 * @throws BusinessException
	 */
	public void removeQuartzTrigger(List<Object> jobTimerIds)
			throws BusinessException {
		List<TriggerKey> triggerKeys = new ArrayList<TriggerKey>();
		String clientId = Session.user.get().getClientId();
		for (Object id : jobTimerIds) {
			triggerKeys.add(new TriggerKey((String) id, clientId));
		}
		Scheduler quartzScheduler = this.getQuartzScheduler();
		try {
			quartzScheduler.unscheduleJobs(triggerKeys);
		} catch (SchedulerException exc) {
			throw new BusinessException("Cannot delete quartz triggers.", exc);
		}
	}

	/**
	 * Create Quartz triggers for a list of {@link JobTimer} entities.
	 * 
	 * @param list
	 * @throws BusinessException
	 */
	public void createQuartzTrigger(List<JobTimer> list, boolean isUpdateContext)
			throws BusinessException {

		Scheduler quartzScheduler = this.getQuartzScheduler();

		for (JobTimer e : list) {
			try {

				JobDetail jobDetail = quartzScheduler.getJobDetail(JobKey
						.jobKey(e.getJobContext().getId().toString(), e
								.getJobContext().getClientId().toString()));

				Trigger newTrigger = this.createQuartzTrigger(e, jobDetail);

				if (isUpdateContext) {
					Trigger oldTrigger = quartzScheduler.getTrigger(TriggerKey
							.triggerKey(e.getId().toString(), e.getClientId()
									.toString()));

					if (oldTrigger == null) {
						quartzScheduler.scheduleJob(newTrigger);
					} else {
						quartzScheduler.rescheduleJob(TriggerKey
								.triggerKey(e.getId().toString(), e
										.getClientId().toString()), newTrigger);
					}
				} else {
					quartzScheduler.scheduleJob(newTrigger);
				}

			} catch (Exception ex) {
				throw new BusinessException("Cannot create timer. Reason: "
						+ ex.getMessage());
			}
		}
	}

	/**
	 * Helper method to create a Quartz Trigger.
	 * 
	 * @param e
	 * @param jobDetail
	 * @return
	 */
	protected Trigger createQuartzTrigger(JobTimer e, JobDetail jobDetail) {
		Trigger newTrigger = null;
		if (e.getType() != null && e.getType().equals("simple")) {

			SimpleScheduleBuilder sb = simpleSchedule().withRepeatCount(
					e.getRepeatCount());

			if (e.getRepeatIntervalType().equals("seconds")) {
				sb = sb.withIntervalInSeconds(e.getRepeatInterval());
			}
			if (e.getRepeatIntervalType().equals("minutes")) {
				sb = sb.withIntervalInMinutes(e.getRepeatInterval());
			}
			if (e.getRepeatIntervalType().equals("hours")) {
				sb = sb.withIntervalInHours(e.getRepeatInterval());
			}

			newTrigger = (SimpleTrigger) newTrigger()
					.withIdentity(e.getId().toString(),
							e.getClientId().toString())
					.startAt(e.getStartTime()).endAt(e.getEndTime())
					.withSchedule(sb).forJob(jobDetail).build();

		} else if (e.getType().equals("cron")) {
			newTrigger = (CronTrigger) newTrigger()
					.withIdentity(e.getId().toString(),
							e.getClientId().toString())
					.startAt(e.getStartTime()).endAt(e.getEndTime())
					.withSchedule(cronSchedule(e.getCronExpression()))
					.forJob(jobDetail).build();
		}
		return newTrigger;
	}

	/**
	 * Get the Quartz scheduler
	 * 
	 * @return
	 * @throws BusinessException
	 */
	protected Scheduler getQuartzScheduler() throws BusinessException {
		try {
			Scheduler scheduler = (Scheduler) this.getApplicationContext()
					.getBean(IScheduler.class).getDelegate();
			return scheduler;
		} catch (BeansException e) {
			throw e;
		} catch (Exception e) {
			throw new BusinessException("Cannot get scheduler.", e);
		}
	}
}

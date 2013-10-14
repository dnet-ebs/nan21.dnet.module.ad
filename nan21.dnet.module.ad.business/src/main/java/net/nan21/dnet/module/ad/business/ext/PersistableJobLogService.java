package net.nan21.dnet.module.ad.business.ext;

import java.util.Date;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.IPersistableLog;
import net.nan21.dnet.core.api.service.IPersistableLogMessage;
import net.nan21.dnet.core.api.service.IPersistableLogService;
import net.nan21.dnet.core.api.service.job.IJob;
import net.nan21.dnet.core.business.service.AbstractBusinessBaseService;
import net.nan21.dnet.module.ad.business.api.scheduler.IJobLogService;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLog;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLogMessage;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;

public class PersistableJobLogService extends AbstractBusinessBaseService
		implements IPersistableLogService {

	@Override
	public String insert(IPersistableLog log) throws BusinessException {

		JobLog jl = new JobLog();
		jl.setStartTime((Date) log.getProperty(IJob.PLK_START_TIME));
		jl.setEndTime((Date) log.getProperty(IJob.PLK_END_TIME));

		for (IPersistableLogMessage m : log.getMessages()) {
			JobLogMessage jlm = new JobLogMessage();
			jlm.setJobLog(jl);
			jlm.setMessage(m.getMessage());
			jlm.setMessageType(m.getType());
			jl.addToMessages(jlm);
		}
		IJobLogService srv = (IJobLogService) this
				.findEntityService(JobLog.class);
		String jobContextId = (String) log.getProperty(IJob.PLK_JOB_CONTEXT);
		String jobTimerId = (String) log.getProperty(IJob.PLK_JOB_TIMER);

		if (jobContextId != null) {
			JobContext jobContext = srv.getEntityManager().find(
					JobContext.class, jobContextId);
			jl.setJobContext(jobContext);
		}

		if (jobTimerId != null) {
			JobTimer jobTimer = srv.getEntityManager().find(JobTimer.class,
					jobTimerId);
			jl.setJobTimer(jobTimer);
		}

		srv.insert(jl);
		return jl.getId();
	}

	@Override
	public String getType() {
		return IPersistableLogService.PL_TYPE_JOB;
	}

}

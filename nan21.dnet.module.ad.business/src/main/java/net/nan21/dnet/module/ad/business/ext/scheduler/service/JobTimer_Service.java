/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.ext.scheduler.service;

import java.util.Date;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.ad.business.api.scheduler.IJobTimerService;
import net.nan21.dnet.module.ad.business.ext.scheduler.delegate.JobScheduler_Bd;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;

/**
 * Business extensions specific for {@link JobTimer} domain entity.
 * 
 */
public class JobTimer_Service extends
		net.nan21.dnet.module.ad.business.impl.scheduler.JobTimer_Service
		implements IJobTimerService {

	@Override
	protected void preInsert(JobTimer e) throws BusinessException {
		if (e.getStartTime() == null) {
			e.setStartTime(new Date());
		}
	}

	@Override
	protected void preUpdate(JobTimer e) throws BusinessException {
		if (e.getStartTime() == null) {
			e.setStartTime(new Date());
		}
	}

	/**
	 * Register timers as Quartz triggers.
	 */
	@Override
	protected void postInsert(List<JobTimer> list) throws BusinessException {
		this.getBusinessDelegate(JobScheduler_Bd.class).createQuartzTrigger(
				list, false);
	}

	/**
	 * Update the associated Quartz triggers
	 */
	@Override
	protected void postUpdate(List<JobTimer> list) throws BusinessException {
		this.getBusinessDelegate(JobScheduler_Bd.class).createQuartzTrigger(
				list, true);
	}

}

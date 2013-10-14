/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.ext.scheduler.service;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.ad.business.api.scheduler.IJobContextParamService;
import net.nan21.dnet.module.ad.business.ext.scheduler.delegate.JobScheduler_Bd;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContextParam;

/**
 * Business extensions specific for {@link JobContextParam} domain entity.
 * 
 */
public class JobContextParam_Service
		extends
		net.nan21.dnet.module.ad.business.impl.scheduler.JobContextParam_Service
		implements IJobContextParamService {

	@Override
	protected void postUpdate(List<JobContextParam> list)
			throws BusinessException {
		List<JobContext> jobContexts = new ArrayList<JobContext>();
		for (JobContextParam o : list) {
			if (!jobContexts.contains(o.getJobContext())) {
				jobContexts.add(o.getJobContext());
			}
		}
		this.getBusinessDelegate(JobScheduler_Bd.class).createQuartzJob(
				jobContexts);
	}

	@Override
	protected void postInsert(List<JobContextParam> list)
			throws BusinessException {
		List<JobContext> jobContexts = new ArrayList<JobContext>();
		for (JobContextParam o : list) {
			if (!jobContexts.contains(o.getJobContext())) {
				jobContexts.add(o.getJobContext());
			}
		}
		this.getBusinessDelegate(JobScheduler_Bd.class).createQuartzJob(
				jobContexts);
	}

}

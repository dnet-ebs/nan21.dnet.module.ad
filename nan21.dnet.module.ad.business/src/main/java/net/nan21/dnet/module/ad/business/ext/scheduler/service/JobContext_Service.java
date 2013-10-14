/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.ext.scheduler.service;

import java.util.List;
import java.util.Map;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.ad.business.api.scheduler.IJobContextService;
import net.nan21.dnet.module.ad.business.api.system.IJobService;
import net.nan21.dnet.module.ad.business.ext.scheduler.delegate.JobScheduler_Bd;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContextParam;
import net.nan21.dnet.module.ad.domain.impl.system.Job;
import net.nan21.dnet.module.ad.domain.impl.system.JobParam;

/**
 * Business extensions specific for {@link JobContext} domain entity.
 * 
 */
public class JobContext_Service extends
		net.nan21.dnet.module.ad.business.impl.scheduler.JobContext_Service
		implements IJobContextService {

	@Override
	protected void preInsert(JobContext e) throws BusinessException {
		Job job = ((IJobService) this.findEntityService(Job.class))
				.findByName(e.getJobName());
		for (JobParam jp : job.getParams()) {
			JobContextParam cp = new JobContextParam();
			cp.setJobContext(e);
			cp.setParamName(jp.getName());
			cp.setDataType(jp.getDataType());
			e.addToParams(cp);
		}
	}

	@Override
	protected void postUpdate(List<JobContext> list) throws BusinessException {
		this.getBusinessDelegate(JobScheduler_Bd.class).createQuartzJob(list);
	}

	@Override
	protected void postInsert(List<JobContext> list) throws BusinessException {
		this.getBusinessDelegate(JobScheduler_Bd.class).createQuartzJob(list);
	}

	@Override
	protected void postDelete(List<JobContext> list) throws BusinessException {
		List<Object> ids = this.collectIds(list);
		this.getBusinessDelegate(JobScheduler_Bd.class).removeQuartzJob(ids);
	}

	@Override
	protected void postDeleteByIds(List<Object> ids, Map<String, Object> context)
			throws BusinessException {
		this.getBusinessDelegate(JobScheduler_Bd.class).removeQuartzJob(ids);
	}

}

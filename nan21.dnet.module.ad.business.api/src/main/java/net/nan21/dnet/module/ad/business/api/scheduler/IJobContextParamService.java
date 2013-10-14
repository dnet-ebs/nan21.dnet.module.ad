/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.scheduler;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContextParam;

/**
 * Interface to expose business functions specific for {@link JobContextParam} domain
 * entity.
 */
public interface IJobContextParamService
		extends
			IEntityService<JobContextParam> {

	/**
	 * Find by unique key
	 */
	public JobContextParam findByName(JobContext jobContext, String paramName);

	/**
	 * Find by unique key
	 */
	public JobContextParam findByName(Long jobContextId, String paramName);

	/**
	 * Find by reference: jobContext
	 */
	public List<JobContextParam> findByJobContext(JobContext jobContext);

	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobContextParam> findByJobContextId(String jobContextId);
}

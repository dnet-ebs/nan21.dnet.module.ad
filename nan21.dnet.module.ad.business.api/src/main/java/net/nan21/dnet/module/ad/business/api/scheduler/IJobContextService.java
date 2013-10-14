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
 * Interface to expose business functions specific for {@link JobContext} domain
 * entity.
 */
public interface IJobContextService extends IEntityService<JobContext> {

	/**
	 * Find by unique key
	 */
	public JobContext findByName(String name);

	/**
	 * Find by reference: params
	 */
	public List<JobContext> findByParams(JobContextParam params);

	/**
	 * Find by ID of reference: params.id
	 */
	public List<JobContext> findByParamsId(String paramsId);
}

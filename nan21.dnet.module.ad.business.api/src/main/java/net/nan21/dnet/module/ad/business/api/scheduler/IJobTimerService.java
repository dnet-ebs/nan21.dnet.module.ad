/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.scheduler;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;

/**
 * Interface to expose business functions specific for {@link JobTimer} domain
 * entity.
 */
public interface IJobTimerService extends IEntityService<JobTimer> {

	/**
	 * Find by unique key
	 */
	public JobTimer findByName(JobContext jobContext, String name);

	/**
	 * Find by unique key
	 */
	public JobTimer findByName(Long jobContextId, String name);

	/**
	 * Find by reference: jobContext
	 */
	public List<JobTimer> findByJobContext(JobContext jobContext);

	/**
	 * Find by ID of reference: jobContext.id
	 */
	public List<JobTimer> findByJobContextId(String jobContextId);
}

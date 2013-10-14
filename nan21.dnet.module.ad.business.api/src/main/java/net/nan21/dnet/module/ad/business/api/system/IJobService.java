/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.system;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.system.Job;
import net.nan21.dnet.module.ad.domain.impl.system.JobParam;

/**
 * Interface to expose business functions specific for {@link Job} domain
 * entity.
 */
public interface IJobService extends IEntityService<Job> {

	/**
	 * Find by unique key
	 */
	public Job findByName(String name);

	/**
	 * Find by unique key
	 */
	public Job findByJclass(String javaClass);

	/**
	 * Find by reference: params
	 */
	public List<Job> findByParams(JobParam params);

	/**
	 * Find by ID of reference: params.id
	 */
	public List<Job> findByParamsId(String paramsId);
}

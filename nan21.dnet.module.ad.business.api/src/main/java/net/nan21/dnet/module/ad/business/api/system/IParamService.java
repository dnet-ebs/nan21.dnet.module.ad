/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.system;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.system.Param;

/**
 * Interface to expose business functions specific for {@link Param} domain
 * entity.
 */
public interface IParamService extends IEntityService<Param> {

	public void doSynchronizeCatalog() throws BusinessException;

	/**
	 * Find by unique key
	 */
	public Param findByCode(String code);

	/**
	 * Find by unique key
	 */
	public Param findByName(String name);
}

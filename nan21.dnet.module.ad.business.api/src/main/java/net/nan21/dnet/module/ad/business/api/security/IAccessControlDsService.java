/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.security;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlDs;

/**
 * Interface to expose business functions specific for {@link AccessControlDs} domain
 * entity.
 */
public interface IAccessControlDsService
		extends
			IEntityService<AccessControlDs> {

	/**
	 * Find by unique key
	 */
	public AccessControlDs findByUnique(AccessControl accessControl,
			String dsName);

	/**
	 * Find by unique key
	 */
	public AccessControlDs findByUnique(Long accessControlId, String dsName);

	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlDs> findByAccessControl(AccessControl accessControl);

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlDs> findByAccessControlId(String accessControlId);
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.security;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlAsgn;

/**
 * Interface to expose business functions specific for {@link AccessControlAsgn} domain
 * entity.
 */
public interface IAccessControlAsgnService
		extends
			IEntityService<AccessControlAsgn> {

	/**
	 * Find by unique key
	 */
	public AccessControlAsgn findByUnique(AccessControl accessControl,
			String asgnName);

	/**
	 * Find by unique key
	 */
	public AccessControlAsgn findByUnique(Long accessControlId, String asgnName);

	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlAsgn> findByAccessControl(
			AccessControl accessControl);

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlAsgn> findByAccessControlId(String accessControlId);
}

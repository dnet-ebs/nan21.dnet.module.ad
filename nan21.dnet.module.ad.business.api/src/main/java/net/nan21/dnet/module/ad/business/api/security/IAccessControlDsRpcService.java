/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.security;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlDsRpc;

/**
 * Interface to expose business functions specific for {@link AccessControlDsRpc} domain
 * entity.
 */
public interface IAccessControlDsRpcService
		extends
			IEntityService<AccessControlDsRpc> {

	/**
	 * Find by unique key
	 */
	public AccessControlDsRpc findByUnique(AccessControl accessControl,
			String dsName, String serviceMethod);

	/**
	 * Find by unique key
	 */
	public AccessControlDsRpc findByUnique(Long accessControlId, String dsName,
			String serviceMethod);

	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlDsRpc> findByAccessControl(
			AccessControl accessControl);

	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlDsRpc> findByAccessControlId(String accessControlId);
}

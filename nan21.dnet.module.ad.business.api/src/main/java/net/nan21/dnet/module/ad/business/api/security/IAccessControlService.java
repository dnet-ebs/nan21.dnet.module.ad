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
import net.nan21.dnet.module.ad.domain.impl.security.Role;

/**
 * Interface to expose business functions specific for {@link AccessControl} domain
 * entity.
 */
public interface IAccessControlService extends IEntityService<AccessControl> {

	/**
	 * Find by unique key
	 */
	public AccessControl findByName(String name);

	/**
	 * Find by reference: dsRules
	 */
	public List<AccessControl> findByDsRules(AccessControlDs dsRules);

	/**
	 * Find by ID of reference: dsRules.id
	 */
	public List<AccessControl> findByDsRulesId(String dsRulesId);

	/**
	 * Find by reference: roles
	 */
	public List<AccessControl> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<AccessControl> findByRolesId(String rolesId);
}

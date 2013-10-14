/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.security;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.security.Menu;
import net.nan21.dnet.module.ad.domain.impl.security.Role;

/**
 * Interface to expose business functions specific for {@link Menu} domain
 * entity.
 */
public interface IMenuService extends IEntityService<Menu> {

	/**
	 * Find by unique key
	 */
	public Menu findByName(String name);

	/**
	 * Find by reference: roles
	 */
	public List<Menu> findByRoles(Role roles);

	/**
	 * Find by ID of reference: roles.id
	 */
	public List<Menu> findByRolesId(String rolesId);
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.security.IRoleService;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.Menu;
import net.nan21.dnet.module.ad.domain.impl.security.MenuItem;
import net.nan21.dnet.module.ad.domain.impl.security.Role;
import net.nan21.dnet.module.ad.domain.impl.security.User;

/**
 * Repository functionality for {@link Role} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class Role_Service extends AbstractEntityService<Role>
		implements
			IRoleService {

	public Role_Service() {
		super();
	}

	public Role_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<Role> getEntityClass() {
		return Role.class;
	}
	/**
	 * Find by unique key
	 */
	public Role findByCode(String code) {
		return (Role) this
				.getEntityManager()
				.createNamedQuery(Role.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public Role findByName(String name) {
		return (Role) this
				.getEntityManager()
				.createNamedQuery(Role.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: users
	 */
	public List<Role> findByUsers(User users) {
		return this.findByUsersId(users.getId());
	}
	/**
	 * Find by ID of reference: users.id
	 */
	public List<Role> findByUsersId(String usersId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.users) c where e.clientId = :clientId and c.id = :usersId",
						Role.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("usersId", usersId).getResultList();
	}
	/**
	 * Find by reference: accessControls
	 */
	public List<Role> findByAccessControls(AccessControl accessControls) {
		return this.findByAccessControlsId(accessControls.getId());
	}
	/**
	 * Find by ID of reference: accessControls.id
	 */
	public List<Role> findByAccessControlsId(String accessControlsId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.accessControls) c where e.clientId = :clientId and c.id = :accessControlsId",
						Role.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControlsId", accessControlsId)
				.getResultList();
	}
	/**
	 * Find by reference: menus
	 */
	public List<Role> findByMenus(Menu menus) {
		return this.findByMenusId(menus.getId());
	}
	/**
	 * Find by ID of reference: menus.id
	 */
	public List<Role> findByMenusId(String menusId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.menus) c where e.clientId = :clientId and c.id = :menusId",
						Role.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("menusId", menusId).getResultList();
	}
	/**
	 * Find by reference: menuItems
	 */
	public List<Role> findByMenuItems(MenuItem menuItems) {
		return this.findByMenuItemsId(menuItems.getId());
	}
	/**
	 * Find by ID of reference: menuItems.id
	 */
	public List<Role> findByMenuItemsId(String menuItemsId) {
		return (List<Role>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from Role e, IN (e.menuItems) c where e.clientId = :clientId and c.id = :menuItemsId",
						Role.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("menuItemsId", menuItemsId).getResultList();
	}
}

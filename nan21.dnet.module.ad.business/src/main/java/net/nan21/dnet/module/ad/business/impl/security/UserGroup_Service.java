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
import net.nan21.dnet.module.ad.business.api.security.IUserGroupService;
import net.nan21.dnet.module.ad.domain.impl.security.User;
import net.nan21.dnet.module.ad.domain.impl.security.UserGroup;

/**
 * Repository functionality for {@link UserGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class UserGroup_Service extends AbstractEntityService<UserGroup>
		implements
			IUserGroupService {

	public UserGroup_Service() {
		super();
	}

	public UserGroup_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<UserGroup> getEntityClass() {
		return UserGroup.class;
	}
	/**
	 * Find by unique key
	 */
	public UserGroup findByCode(String code) {
		return (UserGroup) this
				.getEntityManager()
				.createNamedQuery(UserGroup.NQ_FIND_BY_CODE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("code", code).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public UserGroup findByName(String name) {
		return (UserGroup) this
				.getEntityManager()
				.createNamedQuery(UserGroup.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("name", name).getSingleResult();
	}
	/**
	 * Find by reference: users
	 */
	public List<UserGroup> findByUsers(User users) {
		return this.findByUsersId(users.getId());
	}
	/**
	 * Find by ID of reference: users.id
	 */
	public List<UserGroup> findByUsersId(String usersId) {
		return (List<UserGroup>) this
				.getEntityManager()
				.createQuery(
						"select distinct e from UserGroup e, IN (e.users) c where e.clientId = :clientId and c.id = :usersId",
						UserGroup.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("usersId", usersId).getResultList();
	}
}

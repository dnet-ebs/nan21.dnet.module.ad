/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.security;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.security.User;
import net.nan21.dnet.module.ad.domain.impl.security.UserGroup;

/**
 * Interface to expose business functions specific for {@link UserGroup} domain
 * entity.
 */
public interface IUserGroupService extends IEntityService<UserGroup> {

	/**
	 * Find by unique key
	 */
	public UserGroup findByCode(String code);

	/**
	 * Find by unique key
	 */
	public UserGroup findByName(String name);

	/**
	 * Find by reference: users
	 */
	public List<UserGroup> findByUsers(User users);

	/**
	 * Find by ID of reference: users.id
	 */
	public List<UserGroup> findByUsersId(String usersId);
}

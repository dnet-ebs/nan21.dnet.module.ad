/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.security;

import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

@NamedQueries({
		@NamedQuery(name = Role.NQ_FIND_BY_CODE, query = "SELECT e FROM Role e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Role.NQ_FIND_BY_NAME, query = "SELECT e FROM Role e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Role.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Role.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = Role.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class Role extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "AD_ROLE";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Role.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Role.findByName";

	@ManyToMany(mappedBy = "roles")
	private Collection<User> users;

	@ManyToMany
	@JoinTable(name = "AD_ROLE_ACL", joinColumns = {@JoinColumn(name = "ROLES_ID")}, inverseJoinColumns = {@JoinColumn(name = "ACCESSCONTROLS_ID")})
	private Collection<AccessControl> accessControls;

	@ManyToMany
	@JoinTable(name = "AD_ROLE_MENU", joinColumns = {@JoinColumn(name = "ROLES_ID")}, inverseJoinColumns = {@JoinColumn(name = "MENUS_ID")})
	private Collection<Menu> menus;

	@ManyToMany
	@JoinTable(name = "AD_ROLE_MENUITEM", joinColumns = {@JoinColumn(name = "ROLES_ID")}, inverseJoinColumns = {@JoinColumn(name = "MENUITEMS_ID")})
	private Collection<MenuItem> menuItems;

	public Collection<User> getUsers() {
		return this.users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public Collection<AccessControl> getAccessControls() {
		return this.accessControls;
	}

	public void setAccessControls(Collection<AccessControl> accessControls) {
		this.accessControls = accessControls;
	}

	public Collection<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(Collection<Menu> menus) {
		this.menus = menus;
	}

	public Collection<MenuItem> getMenuItems() {
		return this.menuItems;
	}

	public void setMenuItems(Collection<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

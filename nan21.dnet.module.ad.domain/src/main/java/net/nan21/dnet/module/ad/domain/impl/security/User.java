/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.security;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCode;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = User.NQ_FIND_BY_CODE, query = "SELECT e FROM User e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = User.NQ_FIND_BY_LOGIN, query = "SELECT e FROM User e WHERE e.clientId = :clientId and e.loginName = :loginName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = User.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = User.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = User.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "LOGINNAME"})})
public class User extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "AD_USR";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "User.findByCode";
	/**
	 * Named query find by unique key: Login.
	 */
	public static final String NQ_FIND_BY_LOGIN = "User.findByLogin";

	@NotBlank
	@Column(name = "LOGINNAME", nullable = false, length = 255)
	private String loginName;

	@NotBlank
	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;

	@Column(name = "EMAIL", length = 128)
	private String email;

	@NotNull
	@Column(name = "LOCKED", nullable = false)
	private Boolean locked;

	@Column(name = "DECIMALSEPARATOR", length = 1)
	private String decimalSeparator;

	@Column(name = "THOUSANDSEPARATOR", length = 1)
	private String thousandSeparator;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DateFormat.class)
	@JoinColumn(name = "DATEFORMAT_ID", referencedColumnName = "ID")
	private DateFormat dateFormat;

	@ManyToMany
	@JoinTable(name = "AD_USR_ROLE", joinColumns = {@JoinColumn(name = "USERS_ID")}, inverseJoinColumns = {@JoinColumn(name = "ROLES_ID")})
	private Collection<Role> roles;

	@ManyToMany
	@JoinTable(name = "AD_USR_USRGRP", joinColumns = {@JoinColumn(name = "USERS_ID")}, inverseJoinColumns = {@JoinColumn(name = "GROUPS_ID")})
	private Collection<UserGroup> groups;

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getDecimalSeparator() {
		return this.decimalSeparator;
	}

	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public String getThousandSeparator() {
		return this.thousandSeparator;
	}

	public void setThousandSeparator(String thousandSeparator) {
		this.thousandSeparator = thousandSeparator;
	}

	public DateFormat getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public Collection<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<UserGroup> getGroups() {
		return this.groups;
	}

	public void setGroups(Collection<UserGroup> groups) {
		this.groups = groups;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.locked == null) {
			this.locked = new Boolean(false);
		}
	}
}

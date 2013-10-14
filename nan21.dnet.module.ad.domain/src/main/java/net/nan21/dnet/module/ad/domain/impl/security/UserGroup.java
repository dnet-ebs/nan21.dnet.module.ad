/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.security;

import java.util.Collection;
import javax.persistence.Entity;
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
		@NamedQuery(name = UserGroup.NQ_FIND_BY_CODE, query = "SELECT e FROM UserGroup e WHERE e.clientId = :clientId and e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = UserGroup.NQ_FIND_BY_NAME, query = "SELECT e FROM UserGroup e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = UserGroup.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = UserGroup.TABLE_NAME + "_UK1", columnNames = {
				"CLIENTID", "CODE"}),
		@UniqueConstraint(name = UserGroup.TABLE_NAME + "_UK2", columnNames = {
				"CLIENTID", "NAME"})})
public class UserGroup extends AbstractTypeWithCode {

	public static final String TABLE_NAME = "AD_USRGRP";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "UserGroup.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "UserGroup.findByName";

	@ManyToMany(mappedBy = "groups")
	private Collection<User> users;

	public Collection<User> getUsers() {
		return this.users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

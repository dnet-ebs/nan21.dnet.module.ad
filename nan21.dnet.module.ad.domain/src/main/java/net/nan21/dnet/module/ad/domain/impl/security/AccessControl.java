/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.security;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

@NamedQueries({@NamedQuery(name = AccessControl.NQ_FIND_BY_NAME, query = "SELECT e FROM AccessControl e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AccessControl.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AccessControl.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class AccessControl extends AbstractType {

	public static final String TABLE_NAME = "AD_ACL";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "AccessControl.findByName";

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AccessControlDs.class, mappedBy = "accessControl", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<AccessControlDs> dsRules;

	@ManyToMany(mappedBy = "accessControls")
	private Collection<Role> roles;

	public Collection<AccessControlDs> getDsRules() {
		return this.dsRules;
	}

	public void setDsRules(Collection<AccessControlDs> dsRules) {
		this.dsRules = dsRules;
	}

	public void addToDsRules(AccessControlDs e) {
		if (this.dsRules == null) {
			this.dsRules = new ArrayList<AccessControlDs>();
		}
		e.setAccessControl(this);
		this.dsRules.add(e);
	}

	public Collection<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

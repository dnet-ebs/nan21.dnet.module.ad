/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.security;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = AccessControlDsRpc.NQ_FIND_BY_UNIQUE, query = "SELECT e FROM AccessControlDsRpc e WHERE e.clientId = :clientId and e.accessControl = :accessControl and e.dsName = :dsName and e.serviceMethod = :serviceMethod", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AccessControlDsRpc.NQ_FIND_BY_UNIQUE_PRIMITIVE, query = "SELECT e FROM AccessControlDsRpc e WHERE e.clientId = :clientId and e.accessControl.id = :accessControlId and e.dsName = :dsName and e.serviceMethod = :serviceMethod", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AccessControlDsRpc.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AccessControlDsRpc.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ACCESSCONTROL_ID", "DSNAME",
		"SERVICEMETHOD"})})
public class AccessControlDsRpc extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_ACL_DS_RPC";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Unique.
	 */
	public static final String NQ_FIND_BY_UNIQUE = "AccessControlDsRpc.findByUnique";
	/**
	 * Named query find by unique key: Unique using the ID field for references.
	 */
	public static final String NQ_FIND_BY_UNIQUE_PRIMITIVE = "AccessControlDsRpc.findByUnique_PRIMITIVE";

	@NotBlank
	@Column(name = "DSNAME", nullable = false, length = 255)
	private String dsName;

	@NotBlank
	@Column(name = "SERVICEMETHOD", nullable = false, length = 255)
	private String serviceMethod;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccessControl.class)
	@JoinColumn(name = "ACCESSCONTROL_ID", referencedColumnName = "ID")
	private AccessControl accessControl;

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public String getServiceMethod() {
		return this.serviceMethod;
	}

	public void setServiceMethod(String serviceMethod) {
		this.serviceMethod = serviceMethod;
	}

	public AccessControl getAccessControl() {
		return this.accessControl;
	}

	public void setAccessControl(AccessControl accessControl) {
		if (accessControl != null) {
			this.__validate_client_context__(accessControl.getClientId());
		}
		this.accessControl = accessControl;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

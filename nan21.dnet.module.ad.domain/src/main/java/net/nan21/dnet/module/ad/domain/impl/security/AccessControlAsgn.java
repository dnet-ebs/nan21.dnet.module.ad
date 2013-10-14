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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = AccessControlAsgn.NQ_FIND_BY_UNIQUE, query = "SELECT e FROM AccessControlAsgn e WHERE e.clientId = :clientId and e.accessControl = :accessControl and e.asgnName = :asgnName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AccessControlAsgn.NQ_FIND_BY_UNIQUE_PRIMITIVE, query = "SELECT e FROM AccessControlAsgn e WHERE e.clientId = :clientId and e.accessControl.id = :accessControlId and e.asgnName = :asgnName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AccessControlAsgn.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AccessControlAsgn.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ACCESSCONTROL_ID", "ASGNNAME"})})
public class AccessControlAsgn extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_ACL_ASGN";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Unique.
	 */
	public static final String NQ_FIND_BY_UNIQUE = "AccessControlAsgn.findByUnique";
	/**
	 * Named query find by unique key: Unique using the ID field for references.
	 */
	public static final String NQ_FIND_BY_UNIQUE_PRIMITIVE = "AccessControlAsgn.findByUnique_PRIMITIVE";

	@NotBlank
	@Column(name = "ASGNNAME", nullable = false, length = 255)
	private String asgnName;

	@NotNull
	@Column(name = "QUERYALLOWED", nullable = false)
	private Boolean queryAllowed;

	@NotNull
	@Column(name = "UPDATEALLOWED", nullable = false)
	private Boolean updateAllowed;

	@NotNull
	@Column(name = "IMPORTALLOWED", nullable = false)
	private Boolean importAllowed;

	@NotNull
	@Column(name = "EXPORTALLOWED", nullable = false)
	private Boolean exportAllowed;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccessControl.class)
	@JoinColumn(name = "ACCESSCONTROL_ID", referencedColumnName = "ID")
	private AccessControl accessControl;

	public String getAsgnName() {
		return this.asgnName;
	}

	public void setAsgnName(String asgnName) {
		this.asgnName = asgnName;
	}

	public Boolean getQueryAllowed() {
		return this.queryAllowed;
	}

	public void setQueryAllowed(Boolean queryAllowed) {
		this.queryAllowed = queryAllowed;
	}

	public Boolean getUpdateAllowed() {
		return this.updateAllowed;
	}

	public void setUpdateAllowed(Boolean updateAllowed) {
		this.updateAllowed = updateAllowed;
	}

	public Boolean getImportAllowed() {
		return this.importAllowed;
	}

	public void setImportAllowed(Boolean importAllowed) {
		this.importAllowed = importAllowed;
	}

	public Boolean getExportAllowed() {
		return this.exportAllowed;
	}

	public void setExportAllowed(Boolean exportAllowed) {
		this.exportAllowed = exportAllowed;
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
		if (this.queryAllowed == null) {
			this.queryAllowed = new Boolean(false);
		}
		if (this.updateAllowed == null) {
			this.updateAllowed = new Boolean(false);
		}
		if (this.importAllowed == null) {
			this.importAllowed = new Boolean(false);
		}
		if (this.exportAllowed == null) {
			this.exportAllowed = new Boolean(false);
		}
	}
}

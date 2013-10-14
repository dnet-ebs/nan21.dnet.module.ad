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
		@NamedQuery(name = AccessControlDs.NQ_FIND_BY_UNIQUE, query = "SELECT e FROM AccessControlDs e WHERE e.clientId = :clientId and e.accessControl = :accessControl and e.dsName = :dsName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = AccessControlDs.NQ_FIND_BY_UNIQUE_PRIMITIVE, query = "SELECT e FROM AccessControlDs e WHERE e.clientId = :clientId and e.accessControl.id = :accessControlId and e.dsName = :dsName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = AccessControlDs.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = AccessControlDs.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "ACCESSCONTROL_ID", "DSNAME"})})
public class AccessControlDs extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_ACL_DS";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Unique.
	 */
	public static final String NQ_FIND_BY_UNIQUE = "AccessControlDs.findByUnique";
	/**
	 * Named query find by unique key: Unique using the ID field for references.
	 */
	public static final String NQ_FIND_BY_UNIQUE_PRIMITIVE = "AccessControlDs.findByUnique_PRIMITIVE";

	@NotBlank
	@Column(name = "DSNAME", nullable = false, length = 255)
	private String dsName;

	@NotNull
	@Column(name = "QUERYALLOWED", nullable = false)
	private Boolean queryAllowed;

	@NotNull
	@Column(name = "INSERTALLOWED", nullable = false)
	private Boolean insertAllowed;

	@NotNull
	@Column(name = "UPDATEALLOWED", nullable = false)
	private Boolean updateAllowed;

	@NotNull
	@Column(name = "DELETEALLOWED", nullable = false)
	private Boolean deleteAllowed;

	@NotNull
	@Column(name = "IMPORTALLOWED", nullable = false)
	private Boolean importAllowed;

	@NotNull
	@Column(name = "EXPORTALLOWED", nullable = false)
	private Boolean exportAllowed;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AccessControl.class)
	@JoinColumn(name = "ACCESSCONTROL_ID", referencedColumnName = "ID")
	private AccessControl accessControl;

	public String getDsName() {
		return this.dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public Boolean getQueryAllowed() {
		return this.queryAllowed;
	}

	public void setQueryAllowed(Boolean queryAllowed) {
		this.queryAllowed = queryAllowed;
	}

	public Boolean getInsertAllowed() {
		return this.insertAllowed;
	}

	public void setInsertAllowed(Boolean insertAllowed) {
		this.insertAllowed = insertAllowed;
	}

	public Boolean getUpdateAllowed() {
		return this.updateAllowed;
	}

	public void setUpdateAllowed(Boolean updateAllowed) {
		this.updateAllowed = updateAllowed;
	}

	public Boolean getDeleteAllowed() {
		return this.deleteAllowed;
	}

	public void setDeleteAllowed(Boolean deleteAllowed) {
		this.deleteAllowed = deleteAllowed;
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
		if (this.insertAllowed == null) {
			this.insertAllowed = new Boolean(false);
		}
		if (this.updateAllowed == null) {
			this.updateAllowed = new Boolean(false);
		}
		if (this.deleteAllowed == null) {
			this.deleteAllowed = new Boolean(false);
		}
		if (this.importAllowed == null) {
			this.importAllowed = new Boolean(false);
		}
		if (this.exportAllowed == null) {
			this.exportAllowed = new Boolean(false);
		}
	}
}

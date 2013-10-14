/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlAsgn;

@Ds(entity = AccessControlAsgn.class, sort = {@SortField(field = AccessControlAsgn_Ds.f_asgnName)})
@RefLookups({@RefLookup(refId = AccessControlAsgn_Ds.f_accessControlId, namedQuery = AccessControl.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = AccessControlAsgn_Ds.f_accessControl)})})
public class AccessControlAsgn_Ds
		extends
			AbstractAuditableDs<AccessControlAsgn> {

	public static final String f_asgnName = "asgnName";
	public static final String f_queryAllowed = "queryAllowed";
	public static final String f_updateAllowed = "updateAllowed";
	public static final String f_importAllowed = "importAllowed";
	public static final String f_exportAllowed = "exportAllowed";
	public static final String f_accessControlId = "accessControlId";
	public static final String f_accessControl = "accessControl";

	@DsField
	private String asgnName;

	@DsField
	private Boolean queryAllowed;

	@DsField
	private Boolean updateAllowed;

	@DsField
	private Boolean importAllowed;

	@DsField
	private Boolean exportAllowed;

	@DsField(join = "left", path = "accessControl.id")
	private String accessControlId;

	@DsField(join = "left", path = "accessControl.name")
	private String accessControl;

	public AccessControlAsgn_Ds() {
		super();
	}

	public AccessControlAsgn_Ds(AccessControlAsgn e) {
		super(e);
	}

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

	public String getAccessControlId() {
		return this.accessControlId;
	}

	public void setAccessControlId(String accessControlId) {
		this.accessControlId = accessControlId;
	}

	public String getAccessControl() {
		return this.accessControl;
	}

	public void setAccessControl(String accessControl) {
		this.accessControl = accessControl;
	}
}

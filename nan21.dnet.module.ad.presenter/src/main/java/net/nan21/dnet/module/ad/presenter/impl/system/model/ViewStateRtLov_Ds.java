/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.ad.domain.impl.system.ViewState;

@Ds(entity = ViewState.class, sort = {@SortField(field = ViewStateRtLov_Ds.f_name)})
public class ViewStateRtLov_Ds extends AbstractTypeLov<ViewState> {

	public static final String f_cmp = "cmp";
	public static final String f_cmpType = "cmpType";
	public static final String f_value = "value";
	public static final String f_owner = "owner";

	@DsField
	private String cmp;

	@DsField
	private String cmpType;

	@DsField
	private String value;

	@DsField(path = "createdBy")
	private String owner;

	public ViewStateRtLov_Ds() {
		super();
	}

	public ViewStateRtLov_Ds(ViewState e) {
		super(e);
	}

	public String getCmp() {
		return this.cmp;
	}

	public void setCmp(String cmp) {
		this.cmp = cmp;
	}

	public String getCmpType() {
		return this.cmpType;
	}

	public void setCmpType(String cmpType) {
		this.cmpType = cmpType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getOwner() {
		return this.owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}

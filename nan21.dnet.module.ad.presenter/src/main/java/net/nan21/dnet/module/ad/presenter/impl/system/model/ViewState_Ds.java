/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.ad.domain.impl.system.ViewState;

@Ds(entity = ViewState.class, sort = {@SortField(field = ViewState_Ds.f_name)})
public class ViewState_Ds extends AbstractTypeDs<ViewState> {

	public static final String f_cmp = "cmp";
	public static final String f_cmpType = "cmpType";
	public static final String f_value = "value";

	@DsField
	private String cmp;

	@DsField
	private String cmpType;

	@DsField
	private String value;

	public ViewState_Ds() {
		super();
	}

	public ViewState_Ds(ViewState e) {
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
}

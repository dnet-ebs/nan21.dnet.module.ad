/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeNTDs;
import net.nan21.dnet.module.ad.domain.impl.system.Param;

@Ds(entity = Param.class, sort = {@SortField(field = MyParam_Ds.f_code)})
public class MyParam_Ds extends AbstractTypeWithCodeNTDs<Param> {

	public static final String f_defaultValue = "defaultValue";
	public static final String f_listOfValues = "listOfValues";

	@DsField
	private String defaultValue;

	@DsField
	private String listOfValues;

	public MyParam_Ds() {
		super();
	}

	public MyParam_Ds(Param e) {
		super(e);
	}

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getListOfValues() {
		return this.listOfValues;
	}

	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}
}

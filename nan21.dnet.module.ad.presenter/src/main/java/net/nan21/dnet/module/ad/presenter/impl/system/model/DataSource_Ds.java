/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeNTDs;
import net.nan21.dnet.module.ad.domain.impl.system.DataSource;

@Ds(entity = DataSource.class, sort = {@SortField(field = DataSource_Ds.f_name)})
public class DataSource_Ds extends AbstractTypeNTDs<DataSource> {

	public static final String f_model = "model";
	public static final String f_isAsgn = "isAsgn";

	@DsField
	private String model;

	@DsField
	private Boolean isAsgn;

	public DataSource_Ds() {
		super();
	}

	public DataSource_Ds(DataSource e) {
		super(e);
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsAsgn() {
		return this.isAsgn;
	}

	public void setIsAsgn(Boolean isAsgn) {
		this.isAsgn = isAsgn;
	}
}

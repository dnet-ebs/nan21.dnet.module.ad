/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeNTLov;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceField;

@Ds(entity = DataSourceField.class, sort = {@SortField(field = DataSourceFieldLov_Ds.f_name)})
public class DataSourceFieldLov_Ds extends AbstractTypeNTLov<DataSourceField> {

	public static final String f_dataType = "dataType";
	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSourceName = "dataSourceName";

	@DsField
	private String dataType;

	@DsField(join = "left", path = "dataSource.id")
	private String dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSourceName;

	public DataSourceFieldLov_Ds() {
		super();
	}

	public DataSourceFieldLov_Ds(DataSourceField e) {
		super(e);
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataSourceId() {
		return this.dataSourceId;
	}

	public void setDataSourceId(String dataSourceId) {
		this.dataSourceId = dataSourceId;
	}

	public String getDataSourceName() {
		return this.dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}
}

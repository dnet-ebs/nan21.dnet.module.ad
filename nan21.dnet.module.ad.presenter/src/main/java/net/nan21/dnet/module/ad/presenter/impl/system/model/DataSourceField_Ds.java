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
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceField;

@Ds(entity = DataSourceField.class, sort = {@SortField(field = DataSourceField_Ds.f_name)})
public class DataSourceField_Ds extends AbstractTypeNTDs<DataSourceField> {

	public static final String f_dataType = "dataType";
	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSource = "dataSource";

	@DsField
	private String dataType;

	@DsField(join = "left", path = "dataSource.id")
	private String dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSource;

	public DataSourceField_Ds() {
		super();
	}

	public DataSourceField_Ds(DataSourceField e) {
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

	public String getDataSource() {
		return this.dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
}

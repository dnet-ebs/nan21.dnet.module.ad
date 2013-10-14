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
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceRpc;

@Ds(entity = DataSourceRpc.class, sort = {@SortField(field = DataSourceRpcLov_Ds.f_name)})
public class DataSourceRpcLov_Ds extends AbstractTypeNTLov<DataSourceRpc> {

	public static final String f_dataSourceId = "dataSourceId";
	public static final String f_dataSourceName = "dataSourceName";

	@DsField(join = "left", path = "dataSource.id")
	private String dataSourceId;

	@DsField(join = "left", path = "dataSource.name")
	private String dataSourceName;

	public DataSourceRpcLov_Ds() {
		super();
	}

	public DataSourceRpcLov_Ds(DataSourceRpc e) {
		super(e);
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

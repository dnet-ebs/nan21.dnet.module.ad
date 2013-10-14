/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeNTLov;
import net.nan21.dnet.module.ad.domain.impl.system.DataSource;

@Ds(entity = DataSource.class, jpqlWhere = " e.isAsgn = true ", sort = {@SortField(field = DataSourceAsgnLov_Ds.f_name)})
public class DataSourceAsgnLov_Ds extends AbstractTypeNTLov<DataSource> {

	public DataSourceAsgnLov_Ds() {
		super();
	}

	public DataSourceAsgnLov_Ds(DataSource e) {
		super(e);
	}
}

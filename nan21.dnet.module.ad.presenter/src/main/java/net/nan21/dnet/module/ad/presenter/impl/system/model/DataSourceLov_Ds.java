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

@Ds(entity = DataSource.class, sort = {@SortField(field = DataSourceLov_Ds.f_name)})
public class DataSourceLov_Ds extends AbstractTypeNTLov<DataSource> {

	public DataSourceLov_Ds() {
		super();
	}

	public DataSourceLov_Ds(DataSource e) {
		super(e);
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.presenter.impl.system.model.ParamValue_Ds;
import net.nan21.dnet.module.ad.presenter.impl.system.model.ParamValue_DsParam;

import net.nan21.dnet.core.api.session.Session;

public class ParamValue_DsQb
		extends
			QueryBuilderWithJpql<ParamValue_Ds, ParamValue_Ds, ParamValue_DsParam> {

	@Override
	public void beforeBuildWhere() {
		if (this.params != null && this.params.getValidAt() != null
				&& !"".equals(this.params.getValidAt())) {
			addFilterCondition("  :validAt between e.validFrom and e.validTo ");
			addCustomFilterItem("validAt", this.params.getValidAt());
		}
	}
}

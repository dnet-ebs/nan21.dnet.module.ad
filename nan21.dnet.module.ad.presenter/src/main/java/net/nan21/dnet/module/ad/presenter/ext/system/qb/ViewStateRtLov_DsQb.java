/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.presenter.ext.system.qb;

import net.nan21.dnet.module.ad.presenter.impl.system.model.ViewStateRtLov_Ds;
import net.nan21.dnet.module.ad.presenter.impl.system.model.ViewStateRtLov_DsParam;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;

public class ViewStateRtLov_DsQb
		extends
		QueryBuilderWithJpql<ViewStateRtLov_Ds, ViewStateRtLov_Ds, ViewStateRtLov_DsParam> {

	@Override
	protected void beforeBuildWhere() throws Exception {
		String userCode = Session.user.get().getCode();

		if (this.params.getHideMine() != null
				&& this.params.getHideMine() == true) {
			addFilterCondition("  e.createdBy <> :userCode ");
			addCustomFilterItem("userCode", userCode);
		}

		if (this.params.getHideOthers() != null
				&& this.params.getHideOthers() == true) {
			addFilterCondition("  e.createdBy = :userCode ");
			addCustomFilterItem("userCode", userCode);
		}
	}

}

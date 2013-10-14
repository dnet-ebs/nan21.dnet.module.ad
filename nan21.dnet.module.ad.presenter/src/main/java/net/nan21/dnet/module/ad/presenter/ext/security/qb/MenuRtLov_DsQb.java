/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.presenter.ext.security.qb;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.presenter.impl.security.model.MenuRtLov_Ds;

public class MenuRtLov_DsQb extends
		QueryBuilderWithJpql<MenuRtLov_Ds, MenuRtLov_Ds, Object> {

	@Override
	protected void beforeBuildWhere() throws Exception {

		if (!Session.user.get().getProfile().isAdministrator()) {
			addFilterCondition("  e.id in ( select p.id from  Menu p, IN (p.roles) c where c.code in :pRoles )  ");
			this.addCustomFilterItem("pRoles", Session.user.get().getProfile()
					.getRoles());
		}
	}
}

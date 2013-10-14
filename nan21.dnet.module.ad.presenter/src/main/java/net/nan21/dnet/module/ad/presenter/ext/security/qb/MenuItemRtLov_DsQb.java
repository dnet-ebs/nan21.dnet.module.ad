/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.presenter.ext.security.qb;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.presenter.impl.security.model.MenuItemRtLov_Ds;

public class MenuItemRtLov_DsQb extends
		QueryBuilderWithJpql<MenuItemRtLov_Ds, MenuItemRtLov_Ds, Object> {

	@Override
	protected void beforeBuildWhere() throws Exception {

		if (!Session.user.get().getProfile().isAdministrator()) {

			addFilterCondition("  e.id in ( select p.id from  MenuItem p, IN (p.roles) c where c.code in :pRoles )  ");
			this.addCustomFilterItem("pRoles", Session.user.get().getProfile()
					.getRoles());

		}
	}

}

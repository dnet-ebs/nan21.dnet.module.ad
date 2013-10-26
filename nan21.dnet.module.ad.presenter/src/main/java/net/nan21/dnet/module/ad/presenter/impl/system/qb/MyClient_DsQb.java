/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.presenter.impl.system.model.MyClient_Ds;

import net.nan21.dnet.core.api.session.Session;

public class MyClient_DsQb
		extends
			QueryBuilderWithJpql<MyClient_Ds, MyClient_Ds, Object> {

	@Override
	public void setFilter(MyClient_Ds filter) {
		filter.setId(Session.user.get().getClientId());
		super.setFilter(filter);
	}
}

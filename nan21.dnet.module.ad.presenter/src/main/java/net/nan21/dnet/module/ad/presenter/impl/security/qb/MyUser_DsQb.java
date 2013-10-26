/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.qb;

import net.nan21.dnet.core.presenter.action.query.QueryBuilderWithJpql;
import net.nan21.dnet.module.ad.presenter.impl.security.model.MyUser_Ds;

import net.nan21.dnet.core.api.session.Session;

public class MyUser_DsQb
		extends
			QueryBuilderWithJpql<MyUser_Ds, MyUser_Ds, Object> {

	@Override
	public void setFilter(MyUser_Ds filter) {
		filter.setCode(Session.user.get().getCode());
		super.setFilter(filter);
	}
}

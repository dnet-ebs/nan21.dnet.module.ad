/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.ad.domain.impl.security.User;

@Ds(entity = User.class, sort = {@SortField(field = UserLov_Ds.f_code)})
public class UserLov_Ds extends AbstractTypeWithCodeLov<User> {

	public UserLov_Ds() {
		super();
	}

	public UserLov_Ds(User e) {
		super(e);
	}
}

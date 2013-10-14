/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.ad.domain.impl.security.UserGroup;

@Ds(entity = UserGroup.class, sort = {@SortField(field = UserGroupLov_Ds.f_code)})
public class UserGroupLov_Ds extends AbstractTypeWithCodeLov<UserGroup> {

	public UserGroupLov_Ds() {
		super();
	}

	public UserGroupLov_Ds(UserGroup e) {
		super(e);
	}
}

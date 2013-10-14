/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.ad.domain.impl.security.UserGroup;

@Ds(entity = UserGroup.class, sort = {@SortField(field = UserGroup_Ds.f_code)})
public class UserGroup_Ds extends AbstractTypeWithCodeDs<UserGroup> {

	public UserGroup_Ds() {
		super();
	}

	public UserGroup_Ds(UserGroup e) {
		super(e);
	}
}

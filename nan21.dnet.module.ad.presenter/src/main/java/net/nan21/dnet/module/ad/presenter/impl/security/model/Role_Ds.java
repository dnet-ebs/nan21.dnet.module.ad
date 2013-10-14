/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.ad.domain.impl.security.Role;

@Ds(entity = Role.class, sort = {@SortField(field = Role_Ds.f_code)})
public class Role_Ds extends AbstractTypeWithCodeDs<Role> {

	public Role_Ds() {
		super();
	}

	public Role_Ds(Role e) {
		super(e);
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeLov;
import net.nan21.dnet.module.ad.domain.impl.security.Role;

@Ds(entity = Role.class, sort = {@SortField(field = RoleLov_Ds.f_code)})
public class RoleLov_Ds extends AbstractTypeWithCodeLov<Role> {

	public RoleLov_Ds() {
		super();
	}

	public RoleLov_Ds(Role e) {
		super(e);
	}
}

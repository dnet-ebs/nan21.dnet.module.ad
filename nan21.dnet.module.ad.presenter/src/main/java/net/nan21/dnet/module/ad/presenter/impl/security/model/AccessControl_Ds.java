/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;

@Ds(entity = AccessControl.class, sort = {@SortField(field = AccessControl_Ds.f_name)})
public class AccessControl_Ds extends AbstractTypeDs<AccessControl> {

	public AccessControl_Ds() {
		super();
	}

	public AccessControl_Ds(AccessControl e) {
		super(e);
	}
}

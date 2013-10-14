/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;

@Ds(entity = AccessControl.class, sort = {@SortField(field = AccessControlLov_Ds.f_name)})
public class AccessControlLov_Ds extends AbstractTypeLov<AccessControl> {

	public AccessControlLov_Ds() {
		super();
	}

	public AccessControlLov_Ds(AccessControl e) {
		super(e);
	}
}

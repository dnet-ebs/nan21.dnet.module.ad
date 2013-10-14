/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeNTLov;
import net.nan21.dnet.module.ad.domain.impl.system.Param;

@Ds(entity = Param.class, sort = {@SortField(field = ParamLov_Ds.f_code)})
public class ParamLov_Ds extends AbstractTypeWithCodeNTLov<Param> {

	public ParamLov_Ds() {
		super();
	}

	public ParamLov_Ds(Param e) {
		super(e);
	}
}

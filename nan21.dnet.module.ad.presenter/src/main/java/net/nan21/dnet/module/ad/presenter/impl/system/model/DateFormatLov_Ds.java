/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeNTLov;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;

@Ds(entity = DateFormat.class, sort = {@SortField(field = DateFormatLov_Ds.f_name)})
public class DateFormatLov_Ds extends AbstractTypeNTLov<DateFormat> {

	public DateFormatLov_Ds() {
		super();
	}

	public DateFormatLov_Ds(DateFormat e) {
		super(e);
	}
}

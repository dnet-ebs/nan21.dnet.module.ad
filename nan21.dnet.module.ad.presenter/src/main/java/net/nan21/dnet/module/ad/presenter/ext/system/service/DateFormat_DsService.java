/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.ext.system.service;

import net.nan21.dnet.core.api.service.presenter.IDsService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;
import net.nan21.dnet.module.ad.presenter.impl.system.model.DateFormat_Ds;

public class DateFormat_DsService
		extends
		AbstractEntityDsService<DateFormat_Ds, DateFormat_Ds, Object, DateFormat>
		implements IDsService<DateFormat_Ds, DateFormat_Ds, Object> {

	@Override
	protected boolean canInsert() {
		return this.canChange();
	}

	@Override
	protected boolean canUpdate() {
		return this.canChange();
	}

	@Override
	protected boolean canDelete() {
		return this.canChange();
	}

	private boolean canChange() {
		return Session.user.get().isSystemUser();
	}

}

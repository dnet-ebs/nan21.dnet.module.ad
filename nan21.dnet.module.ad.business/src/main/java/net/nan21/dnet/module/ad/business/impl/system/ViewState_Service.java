/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IViewStateService;
import net.nan21.dnet.module.ad.domain.impl.system.ViewState;

/**
 * Repository functionality for {@link ViewState} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ViewState_Service extends AbstractEntityService<ViewState>
		implements
			IViewStateService {

	public ViewState_Service() {
		super();
	}

	public ViewState_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ViewState> getEntityClass() {
		return ViewState.class;
	}
}

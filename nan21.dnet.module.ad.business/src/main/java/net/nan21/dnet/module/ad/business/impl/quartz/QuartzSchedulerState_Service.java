/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzSchedulerStateService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzSchedulerState;

/**
 * Repository functionality for {@link QuartzSchedulerState} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSchedulerState_Service
		extends
			AbstractEntityService<QuartzSchedulerState>
		implements
			IQuartzSchedulerStateService {

	public QuartzSchedulerState_Service() {
		super();
	}

	public QuartzSchedulerState_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSchedulerState> getEntityClass() {
		return QuartzSchedulerState.class;
	}
}

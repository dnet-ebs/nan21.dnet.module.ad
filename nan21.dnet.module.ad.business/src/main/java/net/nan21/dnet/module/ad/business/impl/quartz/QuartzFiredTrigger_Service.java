/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzFiredTriggerService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzFiredTrigger;

/**
 * Repository functionality for {@link QuartzFiredTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzFiredTrigger_Service
		extends
			AbstractEntityService<QuartzFiredTrigger>
		implements
			IQuartzFiredTriggerService {

	public QuartzFiredTrigger_Service() {
		super();
	}

	public QuartzFiredTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzFiredTrigger> getEntityClass() {
		return QuartzFiredTrigger.class;
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzSimpleTriggerService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzSimpleTrigger;

/**
 * Repository functionality for {@link QuartzSimpleTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSimpleTrigger_Service
		extends
			AbstractEntityService<QuartzSimpleTrigger>
		implements
			IQuartzSimpleTriggerService {

	public QuartzSimpleTrigger_Service() {
		super();
	}

	public QuartzSimpleTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSimpleTrigger> getEntityClass() {
		return QuartzSimpleTrigger.class;
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzCronTriggerService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzCronTrigger;

/**
 * Repository functionality for {@link QuartzCronTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzCronTrigger_Service
		extends
			AbstractEntityService<QuartzCronTrigger>
		implements
			IQuartzCronTriggerService {

	public QuartzCronTrigger_Service() {
		super();
	}

	public QuartzCronTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzCronTrigger> getEntityClass() {
		return QuartzCronTrigger.class;
	}
}

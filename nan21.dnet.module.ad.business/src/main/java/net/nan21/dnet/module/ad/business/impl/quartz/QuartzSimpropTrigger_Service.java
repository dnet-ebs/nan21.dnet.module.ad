/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzSimpropTriggerService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzSimpropTrigger;

/**
 * Repository functionality for {@link QuartzSimpropTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzSimpropTrigger_Service
		extends
			AbstractEntityService<QuartzSimpropTrigger>
		implements
			IQuartzSimpropTriggerService {

	public QuartzSimpropTrigger_Service() {
		super();
	}

	public QuartzSimpropTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzSimpropTrigger> getEntityClass() {
		return QuartzSimpropTrigger.class;
	}
}

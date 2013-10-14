/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzTriggerService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzTrigger;

/**
 * Repository functionality for {@link QuartzTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzTrigger_Service extends AbstractEntityService<QuartzTrigger>
		implements
			IQuartzTriggerService {

	public QuartzTrigger_Service() {
		super();
	}

	public QuartzTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzTrigger> getEntityClass() {
		return QuartzTrigger.class;
	}
}

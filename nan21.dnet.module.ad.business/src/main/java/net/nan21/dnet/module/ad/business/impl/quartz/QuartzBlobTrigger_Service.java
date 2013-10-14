/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzBlobTriggerService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzBlobTrigger;

/**
 * Repository functionality for {@link QuartzBlobTrigger} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzBlobTrigger_Service
		extends
			AbstractEntityService<QuartzBlobTrigger>
		implements
			IQuartzBlobTriggerService {

	public QuartzBlobTrigger_Service() {
		super();
	}

	public QuartzBlobTrigger_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzBlobTrigger> getEntityClass() {
		return QuartzBlobTrigger.class;
	}
}

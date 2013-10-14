/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzPausedTriggerGroupService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzPausedTriggerGroup;

/**
 * Repository functionality for {@link QuartzPausedTriggerGroup} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzPausedTriggerGroup_Service
		extends
			AbstractEntityService<QuartzPausedTriggerGroup>
		implements
			IQuartzPausedTriggerGroupService {

	public QuartzPausedTriggerGroup_Service() {
		super();
	}

	public QuartzPausedTriggerGroup_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzPausedTriggerGroup> getEntityClass() {
		return QuartzPausedTriggerGroup.class;
	}
}

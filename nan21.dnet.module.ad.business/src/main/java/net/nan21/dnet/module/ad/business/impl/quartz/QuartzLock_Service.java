/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzLockService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzLock;

/**
 * Repository functionality for {@link QuartzLock} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzLock_Service extends AbstractEntityService<QuartzLock>
		implements
			IQuartzLockService {

	public QuartzLock_Service() {
		super();
	}

	public QuartzLock_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzLock> getEntityClass() {
		return QuartzLock.class;
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzCalendarService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzCalendar;

/**
 * Repository functionality for {@link QuartzCalendar} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzCalendar_Service
		extends
			AbstractEntityService<QuartzCalendar>
		implements
			IQuartzCalendarService {

	public QuartzCalendar_Service() {
		super();
	}

	public QuartzCalendar_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzCalendar> getEntityClass() {
		return QuartzCalendar.class;
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.quartz;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.quartz.IQuartzJobDetailService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzJobDetail;

/**
 * Repository functionality for {@link QuartzJobDetail} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class QuartzJobDetail_Service
		extends
			AbstractEntityService<QuartzJobDetail>
		implements
			IQuartzJobDetailService {

	public QuartzJobDetail_Service() {
		super();
	}

	public QuartzJobDetail_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<QuartzJobDetail> getEntityClass() {
		return QuartzJobDetail.class;
	}
}

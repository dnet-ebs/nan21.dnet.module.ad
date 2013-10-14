/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.quartz;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.quartz.QuartzBlobTrigger;

/**
 * Interface to expose business functions specific for {@link QuartzBlobTrigger} domain
 * entity.
 */
public interface IQuartzBlobTriggerService
		extends
			IEntityService<QuartzBlobTrigger> {
}

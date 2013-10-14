/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.system;

import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.system.FrameExtension;

/**
 * Interface to expose business functions specific for {@link FrameExtension} domain
 * entity.
 */
public interface IFrameExtensionService extends IEntityService<FrameExtension> {

	/**
	 * Find by unique key
	 */
	public FrameExtension findByName(String frame, String fileLocation);
}

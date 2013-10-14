/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IFrameExtensionService;
import net.nan21.dnet.module.ad.domain.impl.system.FrameExtension;

/**
 * Repository functionality for {@link FrameExtension} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class FrameExtension_Service
		extends
			AbstractEntityService<FrameExtension>
		implements
			IFrameExtensionService {

	public FrameExtension_Service() {
		super();
	}

	public FrameExtension_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<FrameExtension> getEntityClass() {
		return FrameExtension.class;
	}
	/**
	 * Find by unique key
	 */
	public FrameExtension findByName(String frame, String fileLocation) {
		return (FrameExtension) this
				.getEntityManager()
				.createNamedQuery(FrameExtension.NQ_FIND_BY_NAME)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("frame", frame)
				.setParameter("fileLocation", fileLocation).getSingleResult();
	}
}

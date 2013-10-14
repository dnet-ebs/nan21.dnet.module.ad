/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IParamValueService;
import net.nan21.dnet.module.ad.domain.impl.system.ParamValue;

/**
 * Repository functionality for {@link ParamValue} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class ParamValue_Service extends AbstractEntityService<ParamValue>
		implements
			IParamValueService {

	public ParamValue_Service() {
		super();
	}

	public ParamValue_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<ParamValue> getEntityClass() {
		return ParamValue.class;
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.business.ext.system.service;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.descriptor.ISysParamDefinition;
import net.nan21.dnet.core.api.descriptor.ISysParamDefinitions;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.module.ad.business.api.system.IParamService;
import net.nan21.dnet.module.ad.domain.impl.system.Param;

/**
 * Business extensions specific for {@link Param} domain entity.
 * 
 */
public class Param_Service extends
		net.nan21.dnet.module.ad.business.impl.system.Param_Service implements
		IParamService {

	@Override
	public void doSynchronizeCatalog() throws BusinessException {

		List<ISysParamDefinitions> defs = this.getSettings()
				.getParamDefinitions();
		List<Param> entities = new ArrayList<Param>();
		for (ISysParamDefinitions def : defs) {
			for (ISysParamDefinition d : def.getSysParamDefinitions()) {
				Param e = new Param();
				e.setActive(true);
				e.setCode(d.getName());
				e.setName(d.getTitle());
				e.setDefaultValue(d.getDefaultValue());
				e.setListOfValues(d.getListOfValues());
				e.setDescription(d.getDescription());
				entities.add(e);
			}
		}

		this.update("delete from " + Param.class.getSimpleName(), null);
		this.insert(entities);
	}

}

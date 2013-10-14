/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.system;

import java.util.List;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormatMask;

/**
 * Interface to expose business functions specific for {@link DateFormat} domain
 * entity.
 */
public interface IDateFormatService extends IEntityService<DateFormat> {

	/**
	 * Find by unique key
	 */
	public DateFormat findByName(String name);

	/**
	 * Find by reference: masks
	 */
	public List<DateFormat> findByMasks(DateFormatMask masks);

	/**
	 * Find by ID of reference: masks.id
	 */
	public List<DateFormat> findByMasksId(String masksId);
}

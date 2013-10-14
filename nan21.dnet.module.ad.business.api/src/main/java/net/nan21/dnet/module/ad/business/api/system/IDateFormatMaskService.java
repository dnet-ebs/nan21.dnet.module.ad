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
 * Interface to expose business functions specific for {@link DateFormatMask} domain
 * entity.
 */
public interface IDateFormatMaskService extends IEntityService<DateFormatMask> {

	/**
	 * Find by unique key
	 */
	public DateFormatMask findByName(DateFormat dateFormat, String mask);

	/**
	 * Find by unique key
	 */
	public DateFormatMask findByName(Long dateFormatId, String mask);

	/**
	 * Find by reference: dateFormat
	 */
	public List<DateFormatMask> findByDateFormat(DateFormat dateFormat);

	/**
	 * Find by ID of reference: dateFormat.id
	 */
	public List<DateFormatMask> findByDateFormatId(String dateFormatId);
}

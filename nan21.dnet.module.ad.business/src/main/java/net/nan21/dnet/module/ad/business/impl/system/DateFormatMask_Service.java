/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.system;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.system.IDateFormatMaskService;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormatMask;

/**
 * Repository functionality for {@link DateFormatMask} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class DateFormatMask_Service
		extends
			AbstractEntityService<DateFormatMask>
		implements
			IDateFormatMaskService {

	public DateFormatMask_Service() {
		super();
	}

	public DateFormatMask_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<DateFormatMask> getEntityClass() {
		return DateFormatMask.class;
	}
	/**
	 * Find by unique key
	 */
	public DateFormatMask findByName(DateFormat dateFormat, String mask) {
		return (DateFormatMask) this.getEntityManager()
				.createNamedQuery(DateFormatMask.NQ_FIND_BY_NAME)
				.setParameter("dateFormat", dateFormat)
				.setParameter("mask", mask).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public DateFormatMask findByName(Long dateFormatId, String mask) {
		return (DateFormatMask) this.getEntityManager()
				.createNamedQuery(DateFormatMask.NQ_FIND_BY_NAME_PRIMITIVE)
				.setParameter("dateFormatId", dateFormatId)
				.setParameter("mask", mask).getSingleResult();
	}
	/**
	 * Find by reference: dateFormat
	 */
	public List<DateFormatMask> findByDateFormat(DateFormat dateFormat) {
		return this.findByDateFormatId(dateFormat.getId());
	}
	/**
	 * Find by ID of reference: dateFormat.id
	 */
	public List<DateFormatMask> findByDateFormatId(String dateFormatId) {
		return (List<DateFormatMask>) this
				.getEntityManager()
				.createQuery(
						"select e from DateFormatMask e where  e.dateFormat.id = :dateFormatId",
						DateFormatMask.class)
				.setParameter("dateFormatId", dateFormatId).getResultList();
	}
}

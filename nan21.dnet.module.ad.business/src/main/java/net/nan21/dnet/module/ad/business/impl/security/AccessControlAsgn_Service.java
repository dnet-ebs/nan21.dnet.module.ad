/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.impl.security;

import java.util.List;
import javax.persistence.EntityManager;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.entity.AbstractEntityService;
import net.nan21.dnet.module.ad.business.api.security.IAccessControlAsgnService;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlAsgn;

/**
 * Repository functionality for {@link AccessControlAsgn} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccessControlAsgn_Service
		extends
			AbstractEntityService<AccessControlAsgn>
		implements
			IAccessControlAsgnService {

	public AccessControlAsgn_Service() {
		super();
	}

	public AccessControlAsgn_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccessControlAsgn> getEntityClass() {
		return AccessControlAsgn.class;
	}
	/**
	 * Find by unique key
	 */
	public AccessControlAsgn findByUnique(AccessControl accessControl,
			String asgnName) {
		return (AccessControlAsgn) this
				.getEntityManager()
				.createNamedQuery(AccessControlAsgn.NQ_FIND_BY_UNIQUE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControl", accessControl)
				.setParameter("asgnName", asgnName).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AccessControlAsgn findByUnique(Long accessControlId, String asgnName) {
		return (AccessControlAsgn) this
				.getEntityManager()
				.createNamedQuery(AccessControlAsgn.NQ_FIND_BY_UNIQUE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControlId", accessControlId)
				.setParameter("asgnName", asgnName).getSingleResult();
	}
	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlAsgn> findByAccessControl(
			AccessControl accessControl) {
		return this.findByAccessControlId(accessControl.getId());
	}
	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlAsgn> findByAccessControlId(String accessControlId) {
		return (List<AccessControlAsgn>) this
				.getEntityManager()
				.createQuery(
						"select e from AccessControlAsgn e where e.clientId = :clientId and e.accessControl.id = :accessControlId",
						AccessControlAsgn.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControlId", accessControlId)
				.getResultList();
	}
}

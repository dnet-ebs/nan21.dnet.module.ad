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
import net.nan21.dnet.module.ad.business.api.security.IAccessControlDsRpcService;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlDsRpc;

/**
 * Repository functionality for {@link AccessControlDsRpc} domain entity. It contains
 * finder methods based on unique keys as well as reference fields.
 * 
 */
public class AccessControlDsRpc_Service
		extends
			AbstractEntityService<AccessControlDsRpc>
		implements
			IAccessControlDsRpcService {

	public AccessControlDsRpc_Service() {
		super();
	}

	public AccessControlDsRpc_Service(EntityManager em) {
		super();
		this.setEntityManager(em);
	}

	@Override
	public Class<AccessControlDsRpc> getEntityClass() {
		return AccessControlDsRpc.class;
	}
	/**
	 * Find by unique key
	 */
	public AccessControlDsRpc findByUnique(AccessControl accessControl,
			String dsName, String serviceMethod) {
		return (AccessControlDsRpc) this
				.getEntityManager()
				.createNamedQuery(AccessControlDsRpc.NQ_FIND_BY_UNIQUE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControl", accessControl)
				.setParameter("dsName", dsName)
				.setParameter("serviceMethod", serviceMethod).getSingleResult();
	}
	/**
	 * Find by unique key
	 */
	public AccessControlDsRpc findByUnique(Long accessControlId, String dsName,
			String serviceMethod) {
		return (AccessControlDsRpc) this
				.getEntityManager()
				.createNamedQuery(
						AccessControlDsRpc.NQ_FIND_BY_UNIQUE_PRIMITIVE)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControlId", accessControlId)
				.setParameter("dsName", dsName)
				.setParameter("serviceMethod", serviceMethod).getSingleResult();
	}
	/**
	 * Find by reference: accessControl
	 */
	public List<AccessControlDsRpc> findByAccessControl(
			AccessControl accessControl) {
		return this.findByAccessControlId(accessControl.getId());
	}
	/**
	 * Find by ID of reference: accessControl.id
	 */
	public List<AccessControlDsRpc> findByAccessControlId(String accessControlId) {
		return (List<AccessControlDsRpc>) this
				.getEntityManager()
				.createQuery(
						"select e from AccessControlDsRpc e where e.clientId = :clientId and e.accessControl.id = :accessControlId",
						AccessControlDsRpc.class)
				.setParameter("clientId",
						Session.user.get().getClient().getId())
				.setParameter("accessControlId", accessControlId)
				.getResultList();
	}
}

/** 
 * DNet eBusiness Suite
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.security;

import java.util.List;

import javax.persistence.TypedQuery;

import net.nan21.dnet.core.api.Constants;
import net.nan21.dnet.core.api.exceptions.NotAuthorizedRequestException;
import net.nan21.dnet.core.api.security.IAuthorization;
import net.nan21.dnet.core.api.security.IUser;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlDs;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControlDsRpc;

public class AuthorizationForDs extends AbstractSecurity implements
		IAuthorization {

	public void authorize(String dsName, String action, String rpcName)
			throws Exception {

		IUser user = Session.user.get();

		if (user.isSystemUser() || user.getProfile().isAdministrator()) {
			return;
		}

		String filter = null;
		String eql = null;

		if (action.equals(Constants.DS_ACTION_RPC)) {
			filter = " and e.serviceMethod = :serviceMethod ";
			eql = "select 1 from " + AccessControlDsRpc.class.getSimpleName()
					+ " e where e.clientId = :clientId "
					+ " and e.dsName = :dsName " + filter
					+ " and e.accessControl.id in ( select p.id from "
					+ AccessControl.class.getSimpleName()
					+ " p, IN (p.roles) c where c.code in :roles ) ";
		} else {
			filter = this.actionFilter(dsName, action);
			eql = "select 1 from " + AccessControlDs.class.getSimpleName()
					+ " e where e.clientId = :clientId "
					+ " and e.dsName = :dsName " + filter
					+ " and e.accessControl.id in ( select p.id from "
					+ AccessControl.class.getSimpleName()
					+ " p, IN (p.roles) c where c.code in :roles ) ";
		}

		TypedQuery<Integer> query = this.getEntityManager()
				.createQuery(eql, Integer.class)
				.setParameter("dsName", dsName)
				.setParameter("clientId", Session.user.get().getClientId())
				.setParameter("roles", user.getProfile().getRoles());

		if (action.equals(Constants.DS_ACTION_RPC)) {
			query.setParameter("serviceMethod", rpcName);
		}

		List<Integer> result = query.getResultList();
		if (result.size() < 1) {

			throw new NotAuthorizedRequestException(
					"You are not authorized to execute `"
							+ ((rpcName != null) ? rpcName : action)
							+ "`. <BR> Not enough privileges on resource `"
							+ dsName + "`");
		}
	}

	private String actionFilter(String dsName, String action) {

		if (action.equals(Constants.DS_ACTION_QUERY)) {
			return " and e.queryAllowed = true ";
		} else if (action.equals(Constants.DS_ACTION_EXPORT)) {
			return " and e.exportAllowed = true ";
		} else if (action.equals(Constants.DS_ACTION_IMPORT)) {
			return " and e.importAllowed = true ";
		} else if (action.equals(Constants.DS_ACTION_INSERT)) {
			return " and e.insertAllowed = true ";
		} else if (action.equals(Constants.DS_ACTION_UPDATE)) {
			return " and e.updateAllowed = true ";
		} else if (action.equals(Constants.DS_ACTION_DELETE)) {
			return " and e.deleteAllowed = true ";
		}
		return "";
	}

}

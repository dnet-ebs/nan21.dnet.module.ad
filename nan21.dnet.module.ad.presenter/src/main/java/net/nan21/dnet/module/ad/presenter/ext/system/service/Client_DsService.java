/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.presenter.ext.system.service;

import java.io.File;
import java.util.List;

import net.nan21.dnet.core.api.action.impex.IImportDataPackage;
import net.nan21.dnet.core.api.action.query.IQueryBuilder;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.presenter.IDsService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.action.impex.DataPackage;
import net.nan21.dnet.core.presenter.service.ds.AbstractEntityDsService;
import net.nan21.dnet.module.ad.business.api.system.IClientService;
import net.nan21.dnet.module.ad.domain.impl.system.Client;
import net.nan21.dnet.module.ad.presenter.impl.system.model.Client_Ds;
import net.nan21.dnet.module.ad.presenter.impl.system.model.Client_DsParam;

public class Client_DsService extends
		AbstractEntityDsService<Client_Ds, Client_Ds, Client_DsParam, Client>
		implements IDsService<Client_Ds, Client_Ds, Client_DsParam> {

	/**
	 * Custom query. If not a system user, return only the current client.
	 */
	@Override
	public List<Client_Ds> find(
			IQueryBuilder<Client_Ds, Client_Ds, Client_DsParam> builder)
			throws Exception {
		if (!Session.user.get().isSystemUser()) {
			builder.getFilter().setId(Session.user.get().getClientId());
		}
		return super.find(builder);
	}

	/**
	 * Custom insert
	 */
	@Override
	protected void onInsert(List<Client_Ds> list, List<Client> entities,
			Client_DsParam params) throws Exception {

		IClientService srv = (IClientService) this.getEntityService();

		if (params.getInitFileLocation() != null) {

			File f = new File(params.getInitFileLocation());
			if (!f.exists()) {
				throw new BusinessException(
						"Cannot find initial data descriptor file ("
								+ params.getInitFileLocation() + "). ");
			}

			if (!f.canRead()) {
				throw new BusinessException(
						"Read acces not enabled for initial data descriptor file ("
								+ params.getInitFileLocation() + ") . ");
			}

			IImportDataPackage dp = DataPackage.forIndexFile(params
					.getInitFileLocation());

			for (Client e : entities) {
				srv.doInsertWithUserAccountAndSetup(e,
						params.getAdminUserCode(), params.getAdminUserName(),
						params.getAdminUserLogin(), params.getAdminPassword(),
						dp);
			}
		} else {
			for (Client e : entities) {
				srv.doInsertWithUserAccount(e, params.getAdminUserCode(),
						params.getAdminUserName(), params.getAdminUserLogin(),
						params.getAdminPassword());
			}
		}

	}

	// check if action is allowed

	@Override
	protected boolean canInsert() {
		return this.canChange();
	}

	@Override
	protected boolean canUpdate() {
		return this.canChange();
	}

	@Override
	protected boolean canDelete() {
		return this.canChange();
	}

	private boolean canChange() {
		return Session.user.get().isSystemUser();
	}

}

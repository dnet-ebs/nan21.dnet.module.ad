/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.business.api.system;

import net.nan21.dnet.core.api.action.impex.IImportDataPackage;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.service.business.IEntityService;
import net.nan21.dnet.module.ad.domain.impl.system.Client;

/**
 * Interface to expose business functions specific for {@link Client} domain
 * entity.
 */
public interface IClientService extends IEntityService<Client> {

	public void doInsertWithUserAccount(Client client, String userCode,
			String userName, String loginName, String password)
			throws BusinessException;

	public void doInsertWithUserAccountAndSetup(Client client, String userCode,
			String userName, String loginName, String password,
			IImportDataPackage dataPackage) throws BusinessException;
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeNTLov;
import net.nan21.dnet.module.ad.domain.impl.system.Client;

@Ds(entity = Client.class, sort = {@SortField(field = ClientLov_Ds.f_code)})
public class ClientLov_Ds extends AbstractTypeWithCodeNTLov<Client> {

	public ClientLov_Ds() {
		super();
	}

	public ClientLov_Ds(Client e) {
		super(e);
	}
}

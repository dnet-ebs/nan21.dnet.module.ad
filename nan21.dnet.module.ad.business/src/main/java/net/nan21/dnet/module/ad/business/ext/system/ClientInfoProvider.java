package net.nan21.dnet.module.ad.business.ext.system;

import net.nan21.dnet.core.api.security.DnetWorkspace;
import net.nan21.dnet.core.api.security.IWorkspace;
import net.nan21.dnet.core.api.service.IClientInfoProvider;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractBusinessBaseService;
import net.nan21.dnet.module.ad.domain.impl.system.Client;

public class ClientInfoProvider extends AbstractBusinessBaseService implements
		IClientInfoProvider {

	@Override
	public IWorkspace getClientWorkspace() {
		Client c = this.getEntityManager().find(Client.class,
				Session.user.get().getClientId());

		return new DnetWorkspace(c.getWorkspacePath(), c.getImportPath(),
				c.getExportPath(), c.getTempPath());

	}

}

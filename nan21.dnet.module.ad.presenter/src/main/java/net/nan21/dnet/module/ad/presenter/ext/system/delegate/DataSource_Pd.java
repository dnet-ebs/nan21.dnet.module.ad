package net.nan21.dnet.module.ad.presenter.ext.system.delegate;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.Constants;
import net.nan21.dnet.core.api.descriptor.IDsDefinition;
import net.nan21.dnet.core.api.descriptor.IDsDefinitions;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.descriptor.DsDefinition;
import net.nan21.dnet.core.presenter.descriptor.FieldDefinition;
import net.nan21.dnet.core.presenter.service.AbstractPresenterDelegate;
import net.nan21.dnet.module.ad.business.api.system.IDataSourceService;
import net.nan21.dnet.module.ad.domain.impl.system.DataSource;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceField;
import net.nan21.dnet.module.ad.domain.impl.system.DataSourceRpc;
import net.nan21.dnet.module.ad.presenter.impl.system.model.DataSource_Ds;

public class DataSource_Pd extends AbstractPresenterDelegate {

	/**
	 * Scan spring xml files to discover data-source definition and store them
	 * in database for easier access.
	 * 
	 * @param filter
	 * @throws Exception
	 */

	public void synchronizeCatalog(DataSource_Ds filter) throws Exception {

		if (!Session.user.get().isSystemUser()) {
			throw new Exception(
					"This operation is allowed only for system users.");
		}

		@SuppressWarnings("unchecked")
		List<IDsDefinitions> list = (List<IDsDefinitions>) this
				.getApplicationContext().getBean(
						Constants.SPRING_OSGI_DS_DEFINITIONS);
		IDataSourceService srv = (IDataSourceService) this
				.findEntityService(DataSource.class);

		List<DataSource> result = new ArrayList<DataSource>();
		for (IDsDefinitions defs : list) {
			for (IDsDefinition def : defs.getDsDefinitions()) {
				DataSource e = new DataSource();
				e.setName(def.getName());
				e.setModel(def.getModelClass().getCanonicalName());
				e.setActive(true);
				e.setIsAsgn(def.isAsgn());

				for (FieldDefinition fld : ((DsDefinition) def)
						.getModelFields()) {
					DataSourceField f = new DataSourceField();
					f.setName(fld.getName());
					f.setActive(true);
					f.setDataType(fld.getClassName());
					e.addToFields(f);
				}

				List<String> serviceMethods = def.getServiceMethods();
				if (serviceMethods != null) {
					for (String sm : serviceMethods) {
						DataSourceRpc sme = new DataSourceRpc();
						sme.setActive(true);
						sme.setDataSource(e);
						sme.setName(sm);
						e.addToServiceMethods(sme);
					}
				}
				result.add(e);
			}
		}

		srv.update("delete from " + DataSourceField.class.getSimpleName(), null);
		srv.update("delete from " + DataSourceRpc.class.getSimpleName(), null);
		srv.update("delete from " + DataSource.class.getSimpleName(), null);
		srv.insert(result);
	}
}
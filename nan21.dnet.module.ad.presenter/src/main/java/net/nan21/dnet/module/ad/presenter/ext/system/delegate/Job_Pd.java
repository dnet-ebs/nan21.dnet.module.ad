package net.nan21.dnet.module.ad.presenter.ext.system.delegate;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.Constants;
import net.nan21.dnet.core.api.descriptor.IJobDefinition;
import net.nan21.dnet.core.api.descriptor.IJobDefinitions;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.descriptor.FieldDefinition;
import net.nan21.dnet.core.presenter.descriptor.JobDefinition;
import net.nan21.dnet.core.presenter.service.AbstractPresenterDelegate;
import net.nan21.dnet.module.ad.business.api.system.IJobService;
import net.nan21.dnet.module.ad.domain.impl.system.Job;
import net.nan21.dnet.module.ad.domain.impl.system.JobParam;
import net.nan21.dnet.module.ad.presenter.impl.system.model.Job_Ds;

public class Job_Pd extends AbstractPresenterDelegate {

	/**
	 * Scan spring xml files to discover job definition and store them in
	 * database for easier access.
	 * 
	 * @param ds
	 * @throws Exception
	 */
	public void synchronizeCatalog(Job_Ds ds) throws Exception {

		if (!Session.user.get().isSystemUser()) {
			throw new Exception(
					"This operation is allowed only for system users.");
		}

		@SuppressWarnings("unchecked")
		List<IJobDefinitions> list = (List<IJobDefinitions>) this
				.getApplicationContext().getBean(
						Constants.SPRING_OSGI_JOB_DEFINITIONS);
		IJobService srv = (IJobService) this.findEntityService(Job.class);

		List<Job> result = new ArrayList<Job>();
		for (IJobDefinitions defs : list) {
			for (IJobDefinition def : defs.getJobDefinitions()) {
				Job e = new Job();
				e.setName(def.getName());
				e.setJavaClass(def.getJavaClass().getCanonicalName());
				e.setActive(true);

				for (FieldDefinition fld : ((JobDefinition) def).getJobParams()) {
					JobParam p = new JobParam();
					p.setName(fld.getName());
					p.setActive(true);
					p.setDataType(fld.getClassName());
					e.addToParams(p);
				}
				result.add(e);
			}
		}

		srv.update("delete from " + Job.class.getSimpleName(), null);
		srv.insert(result);
	}
}

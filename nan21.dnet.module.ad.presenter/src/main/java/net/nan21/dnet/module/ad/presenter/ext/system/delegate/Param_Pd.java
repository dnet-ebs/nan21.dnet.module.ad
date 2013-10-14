package net.nan21.dnet.module.ad.presenter.ext.system.delegate;

import java.util.ArrayList;
import java.util.List;

import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.presenter.service.AbstractPresenterDelegate;
import net.nan21.dnet.module.ad.business.api.system.IParamService;
import net.nan21.dnet.module.ad.business.api.system.IParamValueService;
import net.nan21.dnet.module.ad.domain.impl.system.Param;
import net.nan21.dnet.module.ad.domain.impl.system.ParamValue;
import net.nan21.dnet.module.ad.presenter.impl.system.model.MyParam_Ds;
import net.nan21.dnet.module.ad.presenter.impl.system.model.MyParam_DsParam;
import net.nan21.dnet.module.ad.presenter.impl.system.model.ParamValue_Ds;
import net.nan21.dnet.module.ad.presenter.impl.system.model.Param_Ds;

public class Param_Pd extends AbstractPresenterDelegate {

	/**
	 * Populate system parameters table with the values read from runtime.
	 * 
	 * @param filter
	 * @throws Exception
	 */
	public void synchronizeCatalog(Param_Ds filter) throws Exception {
		if (!Session.user.get().isSystemUser()) {
			throw new Exception(
					"This operation is allowed only for system users.");
		}
		((IParamService) this.findEntityService(Param.class))
				.doSynchronizeCatalog();
	}

	/**
	 * Update runtime system parameter values .
	 * 
	 * @param filter
	 * @throws Exception
	 */
	public void publishValues(ParamValue_Ds filter) throws Exception {
		this.getSettings().reloadParamValues();
	}

	/**
	 * Create initial values for the given parameters. Value is set to the
	 * parameter default value. Ignores parameters which already have at least
	 * one value set.
	 * 
	 * @param list
	 * @param params
	 * @throws Exception
	 */
	public void createInitialValues(List<MyParam_Ds> list,
			MyParam_DsParam params) throws Exception {

		List<String> codes = new ArrayList<String>();
		for (MyParam_Ds ds : list) {
			codes.add(ds.getCode());
		}

		IParamValueService srv = (IParamValueService) this
				.findEntityService(ParamValue.class);

		List<Param> paramsList = srv
				.getEntityManager()
				.createQuery(
						"select e from "
								+ Param.class.getSimpleName()
								+ " e where e.code in :codes and e.code not in (select distinct v.sysParam from "
								+ ParamValue.class.getSimpleName()
								+ " v where v.clientId = :clientId ) ",
						Param.class)
				.setParameter("clientId", Session.user.get().getClientId())
				.setParameter("codes", codes).getResultList();

		List<ParamValue> values = new ArrayList<ParamValue>();
		for (Param p : paramsList) {
			ParamValue pv = new ParamValue();
			pv.setSysParam(p.getCode());
			pv.setValue(p.getDefaultValue());
			pv.setValidFrom(params.getValidFrom());
			pv.setValidTo(params.getValidTo());
			values.add(pv);
		}

		this.findEntityService(ParamValue.class).insert(values);

	}
}

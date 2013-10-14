/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeNTDs;
import net.nan21.dnet.module.ad.domain.impl.system.JobParam;

@Ds(entity = JobParam.class, sort = {@SortField(field = JobParamLov_Ds.f_name)})
public class JobParamLov_Ds extends AbstractTypeNTDs<JobParam> {

	public JobParamLov_Ds() {
		super();
	}

	public JobParamLov_Ds(JobParam e) {
		super(e);
	}
}

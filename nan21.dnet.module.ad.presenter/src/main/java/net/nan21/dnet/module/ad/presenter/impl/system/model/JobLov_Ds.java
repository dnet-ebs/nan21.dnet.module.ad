/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeNTLov;
import net.nan21.dnet.module.ad.domain.impl.system.Job;

@Ds(entity = Job.class, sort = {@SortField(field = JobLov_Ds.f_name)})
public class JobLov_Ds extends AbstractTypeNTLov<Job> {

	public JobLov_Ds() {
		super();
	}

	public JobLov_Ds(Job e) {
		super(e);
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.scheduler.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;

@Ds(entity = JobContext.class, sort = {@SortField(field = JobContext_Ds.f_name)})
public class JobContext_Ds extends AbstractTypeDs<JobContext> {

	public static final String f_jobName = "jobName";

	@DsField(noUpdate = true)
	private String jobName;

	public JobContext_Ds() {
		super();
	}

	public JobContext_Ds(JobContext e) {
		super(e);
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}

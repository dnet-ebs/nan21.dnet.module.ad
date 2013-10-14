/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.scheduler.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;

@Ds(entity = JobTimer.class, sort = {@SortField(field = JobTimerLov_Ds.f_name)})
public class JobTimerLov_Ds extends AbstractTypeLov<JobTimer> {

	public static final String f_jobContextId = "jobContextId";
	public static final String f_jobContext = "jobContext";
	public static final String f_jobName = "jobName";

	@DsField(join = "left", path = "jobContext.id")
	private String jobContextId;

	@DsField(join = "left", path = "jobContext.name")
	private String jobContext;

	@DsField(join = "left", path = "jobContext.jobName")
	private String jobName;

	public JobTimerLov_Ds() {
		super();
	}

	public JobTimerLov_Ds(JobTimer e) {
		super(e);
	}

	public String getJobContextId() {
		return this.jobContextId;
	}

	public void setJobContextId(String jobContextId) {
		this.jobContextId = jobContextId;
	}

	public String getJobContext() {
		return this.jobContext;
	}

	public void setJobContext(String jobContext) {
		this.jobContext = jobContext;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}

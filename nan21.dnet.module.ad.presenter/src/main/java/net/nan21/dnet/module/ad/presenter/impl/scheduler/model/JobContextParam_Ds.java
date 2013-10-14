/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.scheduler.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.presenter.model.AbstractAuditableDs;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContextParam;

@Ds(entity = JobContextParam.class)
@RefLookups({@RefLookup(refId = JobContextParam_Ds.f_jobContextId, namedQuery = JobContext.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = JobContextParam_Ds.f_jobContext)})})
public class JobContextParam_Ds extends AbstractAuditableDs<JobContextParam> {

	public static final String f_paramName = "paramName";
	public static final String f_dataType = "dataType";
	public static final String f_value = "value";
	public static final String f_jobContextId = "jobContextId";
	public static final String f_jobContext = "jobContext";
	public static final String f_jobName = "jobName";

	@DsField
	private String paramName;

	@DsField
	private String dataType;

	@DsField
	private String value;

	@DsField(join = "left", path = "jobContext.id")
	private String jobContextId;

	@DsField(join = "left", path = "jobContext.name")
	private String jobContext;

	@DsField(join = "left", path = "jobContext.jobName")
	private String jobName;

	public JobContextParam_Ds() {
		super();
	}

	public JobContextParam_Ds(JobContextParam e) {
		super(e);
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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

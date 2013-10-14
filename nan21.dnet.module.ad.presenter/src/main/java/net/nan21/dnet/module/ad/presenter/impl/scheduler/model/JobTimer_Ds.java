/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.scheduler.model;

import java.util.Date;
import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;

@Ds(entity = JobTimer.class, sort = {@SortField(field = JobTimer_Ds.f_name)})
@RefLookups({@RefLookup(refId = JobTimer_Ds.f_jobContextId, namedQuery = JobContext.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = JobTimer_Ds.f_jobContext)})})
public class JobTimer_Ds extends AbstractTypeDs<JobTimer> {

	public static final String f_startTime = "startTime";
	public static final String f_endTime = "endTime";
	public static final String f_type = "type";
	public static final String f_cronExpression = "cronExpression";
	public static final String f_repeatCount = "repeatCount";
	public static final String f_repeatInterval = "repeatInterval";
	public static final String f_repeatIntervalType = "repeatIntervalType";
	public static final String f_jobContextId = "jobContextId";
	public static final String f_jobContext = "jobContext";
	public static final String f_jobName = "jobName";

	@DsField
	private Date startTime;

	@DsField
	private Date endTime;

	@DsField
	private String type;

	@DsField
	private String cronExpression;

	@DsField
	private Integer repeatCount;

	@DsField
	private Integer repeatInterval;

	@DsField
	private String repeatIntervalType;

	@DsField(join = "left", path = "jobContext.id")
	private String jobContextId;

	@DsField(join = "left", path = "jobContext.name")
	private String jobContext;

	@DsField(join = "left", path = "jobContext.jobName")
	private String jobName;

	public JobTimer_Ds() {
		super();
	}

	public JobTimer_Ds(JobTimer e) {
		super(e);
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCronExpression() {
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public Integer getRepeatCount() {
		return this.repeatCount;
	}

	public void setRepeatCount(Integer repeatCount) {
		this.repeatCount = repeatCount;
	}

	public Integer getRepeatInterval() {
		return this.repeatInterval;
	}

	public void setRepeatInterval(Integer repeatInterval) {
		this.repeatInterval = repeatInterval;
	}

	public String getRepeatIntervalType() {
		return this.repeatIntervalType;
	}

	public void setRepeatIntervalType(String repeatIntervalType) {
		this.repeatIntervalType = repeatIntervalType;
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

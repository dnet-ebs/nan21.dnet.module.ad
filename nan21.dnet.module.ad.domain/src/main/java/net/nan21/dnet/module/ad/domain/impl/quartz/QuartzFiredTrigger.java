/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.quartz;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ReadOnly;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = QuartzFiredTrigger.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzFiredTrigger implements Serializable {

	public static final String TABLE_NAME = "QRTZ_FIRED_TRIGGERS";

	private static final long serialVersionUID = -8865917134914502125L;

	@Id
	@NotBlank
	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	private String schedulerName;

	@Id
	@NotBlank
	@Column(name = "ENTRY_ID", nullable = false, length = 255)
	private String entryID;

	@NotBlank
	@Column(name = "TRIGGER_NAME", nullable = false, length = 255)
	private String triggerName;

	@NotBlank
	@Column(name = "TRIGGER_GROUP", nullable = false, length = 255)
	private String triggerGroup;

	@NotBlank
	@Column(name = "INSTANCE_NAME", nullable = false, length = 255)
	private String instanceName;

	@NotNull
	@Column(name = "FIRED_TIME", nullable = false, precision = 13)
	private Long firedTime;

	@NotNull
	@Column(name = "SCHED_TIME", nullable = false, precision = 13)
	private Long scheduledTime;

	@NotNull
	@Column(name = "PRIORITY", nullable = false, precision = 13)
	private Long priority;

	@NotBlank
	@Column(name = "STATE", nullable = false, length = 16)
	private String state;

	@Column(name = "JOB_NAME", length = 255)
	private String jobName;

	@Column(name = "JOB_GROUP", length = 255)
	private String jobGroup;

	@Column(name = "IS_NONCONCURRENT", length = 1)
	private String isNonConcurrent;

	@Column(name = "REQUESTS_RECOVERY", length = 1)
	private String requestsRecovery;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getEntryID() {
		return this.entryID;
	}

	public void setEntryID(String entryID) {
		this.entryID = entryID;
	}

	public String getTriggerName() {
		return this.triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroup() {
		return this.triggerGroup;
	}

	public void setTriggerGroup(String triggerGroup) {
		this.triggerGroup = triggerGroup;
	}

	public String getInstanceName() {
		return this.instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public Long getFiredTime() {
		return this.firedTime;
	}

	public void setFiredTime(Long firedTime) {
		this.firedTime = firedTime;
	}

	public Long getScheduledTime() {
		return this.scheduledTime;
	}

	public void setScheduledTime(Long scheduledTime) {
		this.scheduledTime = scheduledTime;
	}

	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobGroup() {
		return this.jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	public String getIsNonConcurrent() {
		return this.isNonConcurrent;
	}

	public void setIsNonConcurrent(String isNonConcurrent) {
		this.isNonConcurrent = isNonConcurrent;
	}

	public String getRequestsRecovery() {
		return this.requestsRecovery;
	}

	public void setRequestsRecovery(String requestsRecovery) {
		this.requestsRecovery = requestsRecovery;
	}

	@Transient
	public Long getVersion() {
		return 1L;
	}

	public void setVersion(Long version) {
	}

	@PrePersist
	public void prePersist() {
	}
}

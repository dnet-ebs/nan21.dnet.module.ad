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
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ReadOnly;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = QuartzTrigger.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzTrigger implements Serializable {

	public static final String TABLE_NAME = "QRTZ_TRIGGERS";

	private static final long serialVersionUID = -8865917134914502125L;

	@Id
	@NotBlank
	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	private String schedulerName;

	@Id
	@NotBlank
	@Column(name = "TRIGGER_NAME", nullable = false, length = 255)
	private String triggerName;

	@Id
	@NotBlank
	@Column(name = "TRIGGER_GROUP", nullable = false, length = 255)
	private String triggerGroup;

	@NotBlank
	@Column(name = "JOB_NAME", nullable = false, length = 255)
	private String jobName;

	@NotBlank
	@Column(name = "JOB_GROUP", nullable = false, length = 255)
	private String jobGroup;

	@Column(name = "DESCRIPTION", length = 400)
	private String description;

	@Column(name = "NEXT_FIRE_TIME", precision = 13)
	private Long nextFireTime;

	@Column(name = "PREV_FIRE_TIME", precision = 13)
	private Long prevFireTime;

	@Column(name = "PRIORITY", precision = 13)
	private Long priority;

	@Column(name = "TRIGGER_STATE", length = 16)
	private String triggerState;

	@Column(name = "TRIGGER_TYPE", length = 16)
	private String triggerType;

	@Column(name = "START_TIME", precision = 13)
	private Long startTime;

	@Column(name = "END_TIME", precision = 13)
	private Long endTime;

	@Column(name = "CALENDAR_NAME", length = 255)
	private String calendarName;

	@Column(name = "MISFIRE_INSTR", precision = 2)
	private Integer misfireInstr;

	@Lob
	@Column(name = "JOB_DATA")
	private byte[] jobData;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getNextFireTime() {
		return this.nextFireTime;
	}

	public void setNextFireTime(Long nextFireTime) {
		this.nextFireTime = nextFireTime;
	}

	public Long getPrevFireTime() {
		return this.prevFireTime;
	}

	public void setPrevFireTime(Long prevFireTime) {
		this.prevFireTime = prevFireTime;
	}

	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getTriggerState() {
		return this.triggerState;
	}

	public void setTriggerState(String triggerState) {
		this.triggerState = triggerState;
	}

	public String getTriggerType() {
		return this.triggerType;
	}

	public void setTriggerType(String triggerType) {
		this.triggerType = triggerType;
	}

	public Long getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public String getCalendarName() {
		return this.calendarName;
	}

	public void setCalendarName(String calendarName) {
		this.calendarName = calendarName;
	}

	public Integer getMisfireInstr() {
		return this.misfireInstr;
	}

	public void setMisfireInstr(Integer misfireInstr) {
		this.misfireInstr = misfireInstr;
	}

	public byte[] getJobData() {
		return this.jobData;
	}

	public void setJobData(byte[] jobData) {
		this.jobData = jobData;
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

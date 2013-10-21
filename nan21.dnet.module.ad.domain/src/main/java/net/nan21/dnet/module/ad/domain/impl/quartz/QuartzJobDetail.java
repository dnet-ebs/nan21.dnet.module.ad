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
@Table(name = QuartzJobDetail.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzJobDetail implements Serializable {

	public static final String TABLE_NAME = "QRTZ_JOB_DETAILS";

	private static final long serialVersionUID = -8865917134914502125L;

	@Id
	@NotBlank
	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	private String schedulerName;

	@Id
	@NotBlank
	@Column(name = "JOB_NAME", nullable = false, length = 255)
	private String jobName;

	@Id
	@NotBlank
	@Column(name = "JOB_GROUP", nullable = false, length = 255)
	private String jobGroup;

	@Column(name = "DESCRIPTION", length = 400)
	private String description;

	@Column(name = "JOB_CLASS_NAME", length = 255)
	private String jobClassName;

	@Column(name = "IS_DURABLE", length = 1)
	private String isDurable;

	@Column(name = "IS_NONCONCURRENT", length = 1)
	private String isNonConcurrent;

	@Column(name = "IS_UPDATE_DATA", length = 1)
	private String isUpdateData;

	@Column(name = "REQUESTS_RECOVERY", length = 1)
	private String requestsRecovery;

	@Lob
	@Column(name = "JOB_DATA")
	private byte[] jobData;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
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

	public String getJobClassName() {
		return this.jobClassName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

	public String getIsDurable() {
		return this.isDurable;
	}

	public void setIsDurable(String isDurable) {
		this.isDurable = isDurable;
	}

	public String getIsNonConcurrent() {
		return this.isNonConcurrent;
	}

	public void setIsNonConcurrent(String isNonConcurrent) {
		this.isNonConcurrent = isNonConcurrent;
	}

	public String getIsUpdateData() {
		return this.isUpdateData;
	}

	public void setIsUpdateData(String isUpdateData) {
		this.isUpdateData = isUpdateData;
	}

	public String getRequestsRecovery() {
		return this.requestsRecovery;
	}

	public void setRequestsRecovery(String requestsRecovery) {
		this.requestsRecovery = requestsRecovery;
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

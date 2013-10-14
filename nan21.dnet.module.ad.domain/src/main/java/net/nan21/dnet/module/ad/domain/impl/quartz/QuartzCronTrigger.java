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
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.annotations.ReadOnly;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = QuartzCronTrigger.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzCronTrigger implements Serializable {

	public static final String TABLE_NAME = "QRTZ_CRON_TRIGGERS";

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
	@Column(name = "CRON_EXPRESSION", nullable = false, length = 255)
	private String cronExpression;

	@Column(name = "TIME_ZONE_ID", length = 255)
	private String timeZoneID;

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

	public String getCronExpression() {
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getTimeZoneID() {
		return this.timeZoneID;
	}

	public void setTimeZoneID(String timeZoneID) {
		this.timeZoneID = timeZoneID;
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

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
@Table(name = QuartzSimpleTrigger.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzSimpleTrigger implements Serializable {

	public static final String TABLE_NAME = "QRTZ_SIMPLE_TRIGGERS";

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

	@NotNull
	@Column(name = "REPEAT_COUNT", nullable = false, precision = 10)
	private Integer repeatCount;

	@NotNull
	@Column(name = "REPEAT_INTERVAL", nullable = false, precision = 10)
	private Integer repeatInterval;

	@NotNull
	@Column(name = "TIMES_TRIGGERED", nullable = false, precision = 10)
	private Integer timesTriggered;

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

	public Integer getTimesTriggered() {
		return this.timesTriggered;
	}

	public void setTimesTriggered(Integer timesTriggered) {
		this.timesTriggered = timesTriggered;
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

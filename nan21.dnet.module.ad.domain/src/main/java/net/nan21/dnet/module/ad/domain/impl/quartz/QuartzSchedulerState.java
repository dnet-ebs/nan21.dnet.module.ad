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
@Table(name = QuartzSchedulerState.TABLE_NAME)
@ReadOnly
@Cache(type = CacheType.NONE)
public class QuartzSchedulerState implements Serializable {

	public static final String TABLE_NAME = "QRTZ_SCHEDULER_STATE";

	private static final long serialVersionUID = -8865917134914502125L;

	@Id
	@NotBlank
	@Column(name = "SCHED_NAME", nullable = false, length = 255)
	private String schedulerName;

	@Id
	@NotBlank
	@Column(name = "INSTANCE_NAME", nullable = false, length = 255)
	private String instanceName;

	@Column(name = "LAST_CHECKIN_TIME", precision = 13)
	private Long lastCheckinTime;

	@Column(name = "CHECKIN_INTERVAL", precision = 13)
	private Long checkinInterval;

	public String getSchedulerName() {
		return this.schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getInstanceName() {
		return this.instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public Long getLastCheckinTime() {
		return this.lastCheckinTime;
	}

	public void setLastCheckinTime(Long lastCheckinTime) {
		this.lastCheckinTime = lastCheckinTime;
	}

	public Long getCheckinInterval() {
		return this.checkinInterval;
	}

	public void setCheckinInterval(Long checkinInterval) {
		this.checkinInterval = checkinInterval;
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

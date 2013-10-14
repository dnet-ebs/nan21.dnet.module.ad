/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.scheduler;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobLog;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = JobLogMessage.TABLE_NAME)
public class JobLogMessage extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_JOBLOG_MSG";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotBlank
	@Column(name = "MESSAGETYPE", nullable = false, length = 16)
	private String messageType;

	@Column(name = "MESSAGE", length = 4000)
	private String message;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = JobLog.class)
	@JoinColumn(name = "JOBLOG_ID", referencedColumnName = "ID")
	private JobLog jobLog;

	public String getMessageType() {
		return this.messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public JobLog getJobLog() {
		return this.jobLog;
	}

	public void setJobLog(JobLog jobLog) {
		if (jobLog != null) {
			this.__validate_client_context__(jobLog.getClientId());
		}
		this.jobLog = jobLog;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

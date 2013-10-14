/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobTimer;
import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table(name = JobLog.TABLE_NAME)
public class JobLog extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_JOBLOG";

	private static final long serialVersionUID = -8865917134914502125L;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STARTTIME", nullable = false)
	private Date startTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ENDTIME")
	private Date endTime;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = JobContext.class)
	@JoinColumn(name = "JOBCONTEXT_ID", referencedColumnName = "ID")
	private JobContext jobContext;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = JobTimer.class)
	@JoinColumn(name = "JOBTIMER_ID", referencedColumnName = "ID")
	private JobTimer jobTimer;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = JobLogMessage.class, mappedBy = "jobLog", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<JobLogMessage> messages;

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

	public JobContext getJobContext() {
		return this.jobContext;
	}

	public void setJobContext(JobContext jobContext) {
		if (jobContext != null) {
			this.__validate_client_context__(jobContext.getClientId());
		}
		this.jobContext = jobContext;
	}

	public JobTimer getJobTimer() {
		return this.jobTimer;
	}

	public void setJobTimer(JobTimer jobTimer) {
		if (jobTimer != null) {
			this.__validate_client_context__(jobTimer.getClientId());
		}
		this.jobTimer = jobTimer;
	}

	public Collection<JobLogMessage> getMessages() {
		return this.messages;
	}

	public void setMessages(Collection<JobLogMessage> messages) {
		this.messages = messages;
	}

	public void addToMessages(JobLogMessage e) {
		if (this.messages == null) {
			this.messages = new ArrayList<JobLogMessage>();
		}
		e.setJobLog(this);
		this.messages.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

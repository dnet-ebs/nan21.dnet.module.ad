/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.scheduler;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = JobTimer.NQ_FIND_BY_NAME, query = "SELECT e FROM JobTimer e WHERE e.clientId = :clientId and e.jobContext = :jobContext and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = JobTimer.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM JobTimer e WHERE e.clientId = :clientId and e.jobContext.id = :jobContextId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = JobTimer.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = JobTimer.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "JOBCONTEXT_ID", "NAME"})})
public class JobTimer extends AbstractType {

	public static final String TABLE_NAME = "AD_JOBTRG";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "JobTimer.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "JobTimer.findByName_PRIMITIVE";

	@NotBlank
	@Column(name = "TYPE", nullable = false, length = 16)
	private String type;

	@Column(name = "CRONEXPRESSION", length = 400)
	private String cronExpression;

	@Column(name = "REPEATCOUNT", precision = 8)
	private Integer repeatCount;

	@Column(name = "REPEATINTERVAL", precision = 4)
	private Integer repeatInterval;

	@Column(name = "REPEATINTERVALTYPE", length = 16)
	private String repeatIntervalType;

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

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

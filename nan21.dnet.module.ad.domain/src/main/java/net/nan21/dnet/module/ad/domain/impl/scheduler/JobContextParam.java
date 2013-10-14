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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractAuditable;
import net.nan21.dnet.module.ad.domain.impl.scheduler.JobContext;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = JobContextParam.NQ_FIND_BY_NAME, query = "SELECT e FROM JobContextParam e WHERE e.clientId = :clientId and e.jobContext = :jobContext and e.paramName = :paramName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = JobContextParam.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM JobContextParam e WHERE e.clientId = :clientId and e.jobContext.id = :jobContextId and e.paramName = :paramName", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = JobContextParam.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = JobContextParam.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "JOBCONTEXT_ID", "PARAMNAME"})})
public class JobContextParam extends AbstractAuditable {

	public static final String TABLE_NAME = "AD_JOBCTX_PARAM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "JobContextParam.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "JobContextParam.findByName_PRIMITIVE";

	@NotBlank
	@Column(name = "PARAMNAME", nullable = false, length = 255)
	private String paramName;

	@NotBlank
	@Column(name = "DATATYPE", nullable = false, length = 400)
	private String dataType;

	@Column(name = "VALUE", length = 400)
	private String value;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = JobContext.class)
	@JoinColumn(name = "JOBCONTEXT_ID", referencedColumnName = "ID")
	private JobContext jobContext;

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getDataType() {
		return this.dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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

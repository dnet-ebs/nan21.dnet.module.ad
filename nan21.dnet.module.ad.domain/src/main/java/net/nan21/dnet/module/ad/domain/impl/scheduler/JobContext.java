/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.scheduler;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({@NamedQuery(name = JobContext.NQ_FIND_BY_NAME, query = "SELECT e FROM JobContext e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = JobContext.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = JobContext.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class JobContext extends AbstractType {

	public static final String TABLE_NAME = "AD_JOBCTX";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "JobContext.findByName";

	@NotBlank
	@Column(name = "JOBNAME", nullable = false, length = 255)
	private String jobName;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = JobContextParam.class, mappedBy = "jobContext", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<JobContextParam> params;

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Collection<JobContextParam> getParams() {
		return this.params;
	}

	public void setParams(Collection<JobContextParam> params) {
		this.params = params;
	}

	public void addToParams(JobContextParam e) {
		if (this.params == null) {
			this.params = new ArrayList<JobContextParam>();
		}
		e.setJobContext(this);
		this.params.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

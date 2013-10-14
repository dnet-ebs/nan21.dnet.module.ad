/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.system;

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
import net.nan21.dnet.core.domain.impl.AbstractTypeNT;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = Job.NQ_FIND_BY_NAME, query = "SELECT e FROM Job e WHERE e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Job.NQ_FIND_BY_JCLASS, query = "SELECT e FROM Job e WHERE e.javaClass = :javaClass", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Job.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Job.TABLE_NAME + "_UK1", columnNames = {"NAME"}),
		@UniqueConstraint(name = Job.TABLE_NAME + "_UK2", columnNames = {"JAVACLASS"})})
public class Job extends AbstractTypeNT {

	public static final String TABLE_NAME = "SYS_JOB";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Job.findByName";
	/**
	 * Named query find by unique key: Jclass.
	 */
	public static final String NQ_FIND_BY_JCLASS = "Job.findByJclass";

	@NotBlank
	@Column(name = "JAVACLASS", nullable = false, length = 400)
	private String javaClass;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = JobParam.class, mappedBy = "job", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<JobParam> params;

	public String getJavaClass() {
		return this.javaClass;
	}

	public void setJavaClass(String javaClass) {
		this.javaClass = javaClass;
	}

	public Collection<JobParam> getParams() {
		return this.params;
	}

	public void setParams(Collection<JobParam> params) {
		this.params = params;
	}

	public void addToParams(JobParam e) {
		if (this.params == null) {
			this.params = new ArrayList<JobParam>();
		}
		e.setJob(this);
		this.params.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

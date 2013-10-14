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
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractTypeNT;
import org.eclipse.persistence.annotations.CascadeOnDelete;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({
		@NamedQuery(name = DataSource.NQ_FIND_BY_NAME, query = "SELECT e FROM DataSource e WHERE e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = DataSource.NQ_FIND_BY_MODEL, query = "SELECT e FROM DataSource e WHERE e.model = :model", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DataSource.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = DataSource.TABLE_NAME + "_UK1", columnNames = {"NAME"}),
		@UniqueConstraint(name = DataSource.TABLE_NAME + "_UK2", columnNames = {"MODEL"})})
public class DataSource extends AbstractTypeNT {

	public static final String TABLE_NAME = "SYS_DS";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "DataSource.findByName";
	/**
	 * Named query find by unique key: Model.
	 */
	public static final String NQ_FIND_BY_MODEL = "DataSource.findByModel";

	@NotBlank
	@Column(name = "MODEL", nullable = false, length = 400)
	private String model;

	@NotNull
	@Column(name = "ISASGN", nullable = false)
	private Boolean isAsgn;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = DataSourceField.class, mappedBy = "dataSource", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<DataSourceField> fields;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = DataSourceRpc.class, mappedBy = "dataSource", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<DataSourceRpc> serviceMethods;

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getIsAsgn() {
		return this.isAsgn;
	}

	public void setIsAsgn(Boolean isAsgn) {
		this.isAsgn = isAsgn;
	}

	public Collection<DataSourceField> getFields() {
		return this.fields;
	}

	public void setFields(Collection<DataSourceField> fields) {
		this.fields = fields;
	}

	public void addToFields(DataSourceField e) {
		if (this.fields == null) {
			this.fields = new ArrayList<DataSourceField>();
		}
		e.setDataSource(this);
		this.fields.add(e);
	}

	public Collection<DataSourceRpc> getServiceMethods() {
		return this.serviceMethods;
	}

	public void setServiceMethods(Collection<DataSourceRpc> serviceMethods) {
		this.serviceMethods = serviceMethods;
	}

	public void addToServiceMethods(DataSourceRpc e) {
		if (this.serviceMethods == null) {
			this.serviceMethods = new ArrayList<DataSourceRpc>();
		}
		e.setDataSource(this);
		this.serviceMethods.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
		if (this.isAsgn == null) {
			this.isAsgn = new Boolean(false);
		}
	}
}

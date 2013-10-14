/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCodeNT;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

/**
 * Client level system parameter definitions.	 
 */
@NamedQueries({
		@NamedQuery(name = Param.NQ_FIND_BY_CODE, query = "SELECT e FROM Param e WHERE e.code = :code", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = Param.NQ_FIND_BY_NAME, query = "SELECT e FROM Param e WHERE e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Param.TABLE_NAME, uniqueConstraints = {
		@UniqueConstraint(name = Param.TABLE_NAME + "_UK1", columnNames = {"CODE"}),
		@UniqueConstraint(name = Param.TABLE_NAME + "_UK2", columnNames = {"NAME"})})
public class Param extends AbstractTypeWithCodeNT {

	public static final String TABLE_NAME = "SYS_PARAM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Code.
	 */
	public static final String NQ_FIND_BY_CODE = "Param.findByCode";
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Param.findByName";

	@Column(name = "DEFAULTVALUE", length = 400)
	private String defaultValue;

	@Column(name = "LISTOFVALUES", length = 400)
	private String listOfValues;

	public String getDefaultValue() {
		return this.defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getListOfValues() {
		return this.listOfValues;
	}

	public void setListOfValues(String listOfValues) {
		this.listOfValues = listOfValues;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

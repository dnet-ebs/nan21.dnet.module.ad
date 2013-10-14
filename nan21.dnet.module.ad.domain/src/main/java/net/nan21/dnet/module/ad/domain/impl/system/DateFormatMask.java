/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.system;

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
import net.nan21.dnet.core.domain.impl.AbstractAuditableNT;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Format masks associated with a certain date format.
 */
@NamedQueries({
		@NamedQuery(name = DateFormatMask.NQ_FIND_BY_NAME, query = "SELECT e FROM DateFormatMask e WHERE e.dateFormat = :dateFormat and e.mask = :mask", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE)),
		@NamedQuery(name = DateFormatMask.NQ_FIND_BY_NAME_PRIMITIVE, query = "SELECT e FROM DateFormatMask e WHERE e.dateFormat.id = :dateFormatId and e.mask = :mask", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DateFormatMask.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = DateFormatMask.TABLE_NAME
		+ "_UK1", columnNames = {"DATEFORMAT_ID", "MASK"})})
public class DateFormatMask extends AbstractAuditableNT {

	public static final String TABLE_NAME = "SYS_DTFMT_MASK";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "DateFormatMask.findByName";
	/**
	 * Named query find by unique key: Name using the ID field for references.
	 */
	public static final String NQ_FIND_BY_NAME_PRIMITIVE = "DateFormatMask.findByName_PRIMITIVE";

	@NotBlank
	@Column(name = "MASK", nullable = false, length = 32)
	private String mask;

	@NotBlank
	@Column(name = "VALUE", nullable = false, length = 255)
	private String value;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = DateFormat.class)
	@JoinColumn(name = "DATEFORMAT_ID", referencedColumnName = "ID")
	private DateFormat dateFormat;

	public String getMask() {
		return this.mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DateFormat getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(DateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

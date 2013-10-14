/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.system;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
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

/**
 * Redefined date formats available to users.
 */
@NamedQueries({@NamedQuery(name = DateFormat.NQ_FIND_BY_NAME, query = "SELECT e FROM DateFormat e WHERE e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = DateFormat.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = DateFormat.TABLE_NAME
		+ "_UK1", columnNames = {"NAME"})})
public class DateFormat extends AbstractTypeNT {

	public static final String TABLE_NAME = "SYS_DTFMT";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "DateFormat.findByName";

	@OneToMany(fetch = FetchType.LAZY, targetEntity = DateFormatMask.class, mappedBy = "dateFormat", cascade = CascadeType.ALL)
	@CascadeOnDelete
	private Collection<DateFormatMask> masks;

	public Collection<DateFormatMask> getMasks() {
		return this.masks;
	}

	public void setMasks(Collection<DateFormatMask> masks) {
		this.masks = masks;
	}

	public void addToMasks(DateFormatMask e) {
		if (this.masks == null) {
			this.masks = new ArrayList<DateFormatMask>();
		}
		e.setDateFormat(this);
		this.masks.add(e);
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

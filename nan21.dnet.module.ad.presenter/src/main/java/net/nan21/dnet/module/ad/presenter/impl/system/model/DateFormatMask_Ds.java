/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractAuditableNTDs;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormatMask;

@Ds(entity = DateFormatMask.class, sort = {
		@SortField(field = DateFormatMask_Ds.f_dateFormat),
		@SortField(field = DateFormatMask_Ds.f_mask)})
@RefLookups({@RefLookup(refId = DateFormatMask_Ds.f_dateFormatId, namedQuery = DateFormat.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = DateFormatMask_Ds.f_dateFormat)})})
public class DateFormatMask_Ds extends AbstractAuditableNTDs<DateFormatMask> {

	public static final String f_mask = "mask";
	public static final String f_value = "value";
	public static final String f_dateFormatId = "dateFormatId";
	public static final String f_dateFormat = "dateFormat";

	@DsField
	private String mask;

	@DsField
	private String value;

	@DsField(join = "left", path = "dateFormat.id")
	private String dateFormatId;

	@DsField(join = "left", path = "dateFormat.name")
	private String dateFormat;

	public DateFormatMask_Ds() {
		super();
	}

	public DateFormatMask_Ds(DateFormatMask e) {
		super(e);
	}

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

	public String getDateFormatId() {
		return this.dateFormatId;
	}

	public void setDateFormatId(String dateFormatId) {
		this.dateFormatId = dateFormatId;
	}

	public String getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}

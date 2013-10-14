/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.Param;
import net.nan21.dnet.core.api.annotation.RefLookup;
import net.nan21.dnet.core.api.annotation.RefLookups;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeDs;
import net.nan21.dnet.module.ad.domain.impl.security.User;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormat;

@Ds(entity = User.class, sort = {@SortField(field = MyUser_Ds.f_code)})
@RefLookups({@RefLookup(refId = MyUser_Ds.f_dateFormatId, namedQuery = DateFormat.NQ_FIND_BY_NAME, params = {@Param(name = "name", field = MyUser_Ds.f_dateFormat)})})
public class MyUser_Ds extends AbstractTypeWithCodeDs<User> {

	public static final String f_email = "email";
	public static final String f_loginName = "loginName";
	public static final String f_decimalSeparator = "decimalSeparator";
	public static final String f_thousandSeparator = "thousandSeparator";
	public static final String f_dateFormatId = "dateFormatId";
	public static final String f_dateFormat = "dateFormat";

	@DsField
	private String email;

	@DsField
	private String loginName;

	@DsField
	private String decimalSeparator;

	@DsField
	private String thousandSeparator;

	@DsField(join = "left", path = "dateFormat.id")
	private String dateFormatId;

	@DsField(join = "left", path = "dateFormat.name")
	private String dateFormat;

	public MyUser_Ds() {
		super();
	}

	public MyUser_Ds(User e) {
		super(e);
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getDecimalSeparator() {
		return this.decimalSeparator;
	}

	public void setDecimalSeparator(String decimalSeparator) {
		this.decimalSeparator = decimalSeparator;
	}

	public String getThousandSeparator() {
		return this.thousandSeparator;
	}

	public void setThousandSeparator(String thousandSeparator) {
		this.thousandSeparator = thousandSeparator;
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

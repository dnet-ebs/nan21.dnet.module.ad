/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeLov;
import net.nan21.dnet.module.ad.domain.impl.security.Menu;

@Ds(entity = Menu.class, sort = {@SortField(field = MenuRtLov_Ds.f_sequenceNo)})
public class MenuRtLov_Ds extends AbstractTypeLov<Menu> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_title = "title";

	@DsField
	private Integer sequenceNo;

	@DsField
	private String title;

	public MenuRtLov_Ds() {
		super();
	}

	public MenuRtLov_Ds(Menu e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

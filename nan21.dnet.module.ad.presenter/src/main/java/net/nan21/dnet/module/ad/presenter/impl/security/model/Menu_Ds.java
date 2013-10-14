/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeDs;
import net.nan21.dnet.module.ad.domain.impl.security.Menu;

@Ds(entity = Menu.class, sort = {@SortField(field = Menu_Ds.f_name)})
public class Menu_Ds extends AbstractTypeDs<Menu> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_title = "title";

	@DsField
	private Integer sequenceNo;

	@DsField
	private String title;

	public Menu_Ds() {
		super();
	}

	public Menu_Ds(Menu e) {
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

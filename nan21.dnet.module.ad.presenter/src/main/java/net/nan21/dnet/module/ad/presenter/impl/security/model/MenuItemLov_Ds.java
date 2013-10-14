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
import net.nan21.dnet.module.ad.domain.impl.security.MenuItem;

@Ds(entity = MenuItem.class, sort = {@SortField(field = MenuItemLov_Ds.f_name)})
public class MenuItemLov_Ds extends AbstractTypeLov<MenuItem> {

	public static final String f_title = "title";

	@DsField
	private String title;

	public MenuItemLov_Ds() {
		super();
	}

	public MenuItemLov_Ds(MenuItem e) {
		super(e);
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

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

@Ds(entity = Menu.class, sort = {@SortField(field = MenuLov_Ds.f_name)})
public class MenuLov_Ds extends AbstractTypeLov<Menu> {

	public static final String f_title = "title";

	@DsField
	private String title;

	public MenuLov_Ds() {
		super();
	}

	public MenuLov_Ds(Menu e) {
		super(e);
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

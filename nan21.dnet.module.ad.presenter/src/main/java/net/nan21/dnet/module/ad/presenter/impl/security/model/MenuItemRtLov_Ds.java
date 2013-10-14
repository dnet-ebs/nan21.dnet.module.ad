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
import net.nan21.dnet.module.ad.domain.impl.security.MenuItem;

@Ds(entity = MenuItem.class, jpqlWhere = " e.active = true ", sort = {@SortField(field = MenuItemRtLov_Ds.f_sequenceNo)})
public class MenuItemRtLov_Ds extends AbstractTypeDs<MenuItem> {

	public static final String f_sequenceNo = "sequenceNo";
	public static final String f_text = "text";
	public static final String f_frame = "frame";
	public static final String f_bundle = "bundle";
	public static final String f_leaf = "leaf";
	public static final String f_iconUrl = "iconUrl";
	public static final String f_separatorBefore = "separatorBefore";
	public static final String f_separatorAfter = "separatorAfter";
	public static final String f_menuItemId = "menuItemId";
	public static final String f_menuItem = "menuItem";
	public static final String f_menuId = "menuId";
	public static final String f_menu = "menu";

	@DsField
	private Integer sequenceNo;

	@DsField(path = "title")
	private String text;

	@DsField
	private String frame;

	@DsField
	private String bundle;

	@DsField(fetch = false, path = "leafNode")
	private Boolean leaf;

	@DsField
	private String iconUrl;

	@DsField
	private Boolean separatorBefore;

	@DsField
	private Boolean separatorAfter;

	@DsField(join = "left", path = "menuItem.id")
	private String menuItemId;

	@DsField(join = "left", path = "menuItem.name")
	private String menuItem;

	@DsField(join = "left", path = "menu.id")
	private String menuId;

	@DsField(join = "left", path = "menu.name")
	private String menu;

	public MenuItemRtLov_Ds() {
		super();
	}

	public MenuItemRtLov_Ds(MenuItem e) {
		super(e);
	}

	public Integer getSequenceNo() {
		return this.sequenceNo;
	}

	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getBundle() {
		return this.bundle;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public Boolean getLeaf() {
		return this.leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getIconUrl() {
		return this.iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Boolean getSeparatorBefore() {
		return this.separatorBefore;
	}

	public void setSeparatorBefore(Boolean separatorBefore) {
		this.separatorBefore = separatorBefore;
	}

	public Boolean getSeparatorAfter() {
		return this.separatorAfter;
	}

	public void setSeparatorAfter(Boolean separatorAfter) {
		this.separatorAfter = separatorAfter;
	}

	public String getMenuItemId() {
		return this.menuItemId;
	}

	public void setMenuItemId(String menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
}

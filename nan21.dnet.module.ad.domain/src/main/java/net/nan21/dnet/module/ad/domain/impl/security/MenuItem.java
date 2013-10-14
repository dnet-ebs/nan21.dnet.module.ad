/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.security;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import net.nan21.dnet.core.domain.impl.AbstractType;
import net.nan21.dnet.module.ad.domain.impl.security.Menu;
import net.nan21.dnet.module.ad.domain.impl.security.MenuItem;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({@NamedQuery(name = MenuItem.NQ_FIND_BY_NAME, query = "SELECT e FROM MenuItem e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = MenuItem.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = MenuItem.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class MenuItem extends AbstractType {

	public static final String TABLE_NAME = "AD_MENU_ITEM";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "MenuItem.findByName";

	@Column(name = "SEQUENCENO", precision = 4)
	private Integer sequenceNo;

	@NotBlank
	@Column(name = "TITLE", nullable = false, length = 255)
	private String title;

	@Column(name = "FRAME", length = 255)
	private String frame;

	@Column(name = "BUNDLE", length = 255)
	private String bundle;

	@Column(name = "ICONURL", length = 255)
	private String iconUrl;

	@Column(name = "SEPARATORBEFORE")
	private Boolean separatorBefore;

	@Column(name = "SEPARATORAFTER")
	private Boolean separatorAfter;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = MenuItem.class)
	@JoinColumn(name = "MENUITEM_ID", referencedColumnName = "ID")
	private MenuItem menuItem;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Menu.class)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "ID")
	private Menu menu;

	@ManyToMany(mappedBy = "menuItems")
	private Collection<Role> roles;

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

	@Transient
	public Boolean getLeafNode() {
		return (this.frame != null && !this.frame.equals(""));
	}

	public void setLeafNode(Boolean leafNode) {
	}

	public MenuItem getMenuItem() {
		return this.menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		if (menuItem != null) {
			this.__validate_client_context__(menuItem.getClientId());
		}
		this.menuItem = menuItem;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		if (menu != null) {
			this.__validate_client_context__(menu.getClientId());
		}
		this.menu = menu;
	}

	public Collection<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

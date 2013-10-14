/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.security;

import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import net.nan21.dnet.core.domain.impl.AbstractType;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;
import org.hibernate.validator.constraints.NotBlank;

@NamedQueries({@NamedQuery(name = Menu.NQ_FIND_BY_NAME, query = "SELECT e FROM Menu e WHERE e.clientId = :clientId and e.name = :name", hints = @QueryHint(name = QueryHints.BIND_PARAMETERS, value = HintValues.TRUE))})
@Entity
@Table(name = Menu.TABLE_NAME, uniqueConstraints = {@UniqueConstraint(name = Menu.TABLE_NAME
		+ "_UK1", columnNames = {"CLIENTID", "NAME"})})
public class Menu extends AbstractType {

	public static final String TABLE_NAME = "AD_MENU";

	private static final long serialVersionUID = -8865917134914502125L;
	/**
	 * Named query find by unique key: Name.
	 */
	public static final String NQ_FIND_BY_NAME = "Menu.findByName";

	@NotNull
	@Column(name = "SEQUENCENO", nullable = false, precision = 4)
	private Integer sequenceNo;

	@NotBlank
	@Column(name = "TITLE", nullable = false, length = 255)
	private String title;

	@ManyToMany(mappedBy = "menus")
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

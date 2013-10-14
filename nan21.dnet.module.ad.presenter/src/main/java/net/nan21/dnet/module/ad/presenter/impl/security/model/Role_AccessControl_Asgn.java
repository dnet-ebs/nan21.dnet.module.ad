/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractAsgnModel;
import net.nan21.dnet.module.ad.domain.impl.security.AccessControl;

@Ds(entity=AccessControl.class, sort={@SortField(field=Role_AccessControl_Asgn.f_name)})
public class Role_AccessControl_Asgn extends AbstractAsgnModel<AccessControl> {
	
	public static final String f_id = "id";
	public static final String f_name = "name";
	public static final String f_description = "description";
	
	@DsField(path="id")
	private String  id;
	
	@DsField(path="name")
	private String  name;
	
	@DsField(path="description")
	private String  description;
	
	public Role_AccessControl_Asgn() {
	}
	
	public Role_AccessControl_Asgn(AccessControl e) {
		super();
		this.id = e.getId();
		this.name = e.getName();
		this.description = e.getDescription();
	}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
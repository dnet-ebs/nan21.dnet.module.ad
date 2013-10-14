/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

/* model */
Ext.define(Dnet.ns.ad + "MenuItem_Role_Asgn$Model", {
	extend: 'Ext.data.Model',
	fields:  [
		{name:"id",type:"string"},
		{name:"code",type:"string"},
		{name:"name",type:"string"},
		{name:"description",type:"string"}
	]
});

/* lists */
Ext.define( Dnet.ns.ad + "MenuItem_Role_Asgn$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.ad_MenuItem_Role_Asgn$Left","widget.ad_MenuItem_Role_Asgn$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({name:"id", dataIndex:"id", hidden:true})
		.addTextColumn({name:"code", dataIndex:"code", width:120})
		.addTextColumn({name:"name", dataIndex:"name"})
		.addTextColumn({name:"description", dataIndex:"description", hidden:true})
	} 
});
	
/* ui-window */
Ext.define(Dnet.ns.ad + "MenuItem_Role_Asgn$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
	width:800,
	height:400,
	title:"Assign roles to menu-item",
	_filterFields_: [
		["id"],
		["code"],
		["name"]
	],
	_defaultFilterField_ : "code",

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"ad_MenuItem_Role_Asgn$Left"})
			.addRightGrid({ xtype:"ad_MenuItem_Role_Asgn$Right"})
	}
});

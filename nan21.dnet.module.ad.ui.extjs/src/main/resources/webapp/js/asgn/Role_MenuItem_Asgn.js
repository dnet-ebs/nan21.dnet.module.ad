/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

/* model */
Ext.define(Dnet.ns.ad + "Role_MenuItem_Asgn$Model", {
	extend: 'Ext.data.Model',
	fields:  [
		{name:"id",type:"string"},
		{name:"name",type:"string"},
		{name:"title",type:"string"}
	]
});

/* lists */
Ext.define( Dnet.ns.ad + "Role_MenuItem_Asgn$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.ad_Role_MenuItem_Asgn$Left","widget.ad_Role_MenuItem_Asgn$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({name:"id", dataIndex:"id", hidden:true})
		.addTextColumn({name:"name", dataIndex:"name"})
		.addTextColumn({name:"title", dataIndex:"title"})
	} 
});
	
/* ui-window */
Ext.define(Dnet.ns.ad + "Role_MenuItem_Asgn$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
	width:800,
	height:400,
	title:"Assign menu-items to role",
	_filterFields_: [
		["id"],
		["name"],
		["title"]
	],
	_defaultFilterField_ : "name",

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"ad_Role_MenuItem_Asgn$Left"})
			.addRightGrid({ xtype:"ad_Role_MenuItem_Asgn$Right"})
	}
});

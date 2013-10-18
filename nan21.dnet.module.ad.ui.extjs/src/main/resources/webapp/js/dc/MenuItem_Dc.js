/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "MenuItem_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	paramModel: Dnet.ns.ad + "MenuItem_DsParam",
	recordModel: Dnet.ns.ad + "MenuItem_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "MenuItem_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_MenuItem_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"title", dataIndex:"title"})
		.addLov({name:"name", dataIndex:"name", xtype:"ad_MenuItems_Lov",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"frame", dataIndex:"frame"})
		.addTextField({ name:"bundle", dataIndex:"bundle"})
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"separatorBefore", dataIndex:"separatorBefore"})
		.addBooleanField({ name:"separatorAfter", dataIndex:"separatorAfter"})
		.addBooleanField({ name:"foldersOnly", paramIndex:"foldersOnly"})
		.addBooleanField({ name:"framesOnly", paramIndex:"framesOnly"})
		.addLov({name:"menuItem", dataIndex:"menuItem", xtype:"ad_MenuItems_Lov",
			retFieldMapping: [{lovField:"id", dsField: "menuItemId"} ]})
		.addLov({name:"menu", dataIndex:"menu", xtype:"ad_Menus_Lov",
			retFieldMapping: [{lovField:"id", dsField: "menuId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"})
		.addPanel({ name:"col3", width:250, layout:"form"})
		.addPanel({ name:"col4", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3", "col4"])
		.addChildrenTo("col1", ["name", "title", "frame", "bundle"])
		.addChildrenTo("col2", ["active", "separatorBefore", "separatorAfter"])
		.addChildrenTo("col3", ["menu", "menuItem", "iconUrl"])
		.addChildrenTo("col4", ["foldersOnly", "framesOnly"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.ad + "MenuItem_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_MenuItem_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addNumberColumn({ name:"sequenceNo", dataIndex:"sequenceNo", width:70})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"title", dataIndex:"title", width:200})
		.addTextColumn({ name:"menuItem", dataIndex:"menuItem", width:200})
		.addTextColumn({ name:"menu", dataIndex:"menu", width:200})
		.addTextColumn({ name:"frame", dataIndex:"frame", width:200})
		.addTextColumn({ name:"bundle", dataIndex:"bundle", width:200})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"description", dataIndex:"description", width:200})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.ad + "MenuItem_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_MenuItem_Dc$EditList",
	_bulkEditFields_: ["menu","menuItem","active","bundle","frame","sequenceNo"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right", width:70 })
		.addTextColumn({name:"name", dataIndex:"name", width:150})
		.addTextColumn({name:"title", dataIndex:"title", width:150})
		.addLov({name:"menu", dataIndex:"menu", xtype:"gridcolumn", width:80, 
			editor:{xtype:"ad_Menus_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "menuId"} ]}})
		.addLov({name:"menuItem", dataIndex:"menuItem", xtype:"gridcolumn", width:120, 
			editor:{xtype:"ad_MenuItems_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "menuItemId"} ]}})
		.addTextColumn({name:"frame", dataIndex:"frame", width:150})
		.addTextColumn({name:"bundle", dataIndex:"bundle", width:150})
		.addBooleanColumn({name:"active", dataIndex:"active", width:70})
		.addTextColumn({name:"description", dataIndex:"description", hidden:true, width:200})
		.addBooleanColumn({name:"separatorBefore", dataIndex:"separatorBefore", hidden:true})
		.addBooleanColumn({name:"separatorAfter", dataIndex:"separatorAfter", hidden:true})
		.addTextColumn({name:"iconUrl", dataIndex:"iconUrl", hidden:true, width:100})
		.addTextColumn({name:"menuId", dataIndex:"menuId", hidden:true, width:100})
		.addTextColumn({name:"menuItemId", dataIndex:"menuItemId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.ad + "MenuItem_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_MenuItem_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"title", dataIndex:"title"})
		.addTextField({ name:"frame", dataIndex:"frame"})
		.addTextField({ name:"bundle", dataIndex:"bundle"})
		.addTextField({ name:"iconUrl", dataIndex:"iconUrl"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"separatorBefore", dataIndex:"separatorBefore"})
		.addBooleanField({ name:"separatorAfter", dataIndex:"separatorAfter"})
		.addLov({name:"menuItem", dataIndex:"menuItem", xtype:"ad_MenuItems_Lov",
			retFieldMapping: [{lovField:"id", dsField: "menuItemId"} ]})
		.addLov({name:"menu", dataIndex:"menu", xtype:"ad_Menus_Lov",
			retFieldMapping: [{lovField:"id", dsField: "menuId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "title", "separatorBefore", "separatorAfter", "iconUrl", "active"])
		.addChildrenTo("col2", ["menu", "menuItem", "frame", "bundle"]);
	}
});

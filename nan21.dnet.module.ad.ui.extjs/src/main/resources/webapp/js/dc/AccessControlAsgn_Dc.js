/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "AccessControlAsgn_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "AccessControlAsgn_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "AccessControlAsgn_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_AccessControlAsgn_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"asgnName", dataIndex:"asgnName", xtype:"ad_DataSourcesAsgn_Lov"})
		.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"ad_AccessControls_Lov",
			retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]})
		.addBooleanField({ name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanField({ name:"updateAllowed", dataIndex:"updateAllowed"})
		.addBooleanField({ name:"importAllowed", dataIndex:"importAllowed"})
		.addBooleanField({ name:"exportAllowed", dataIndex:"exportAllowed"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:250, layout:"form"})
		.addPanel({ name:"col2", width:180, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["accessControl", "asgnName"])
		.addChildrenTo("col2", ["queryAllowed", "updateAllowed"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.ad + "AccessControlAsgn_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlAsgn_Dc$EditList",
	_bulkEditFields_: ["queryAllowed","updateAllowed"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"accessControl", dataIndex:"accessControl", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_AccessControls_Lov", selectOnFocus:true,
				retFieldMapping: [{lovField:"id", dsField: "accessControlId"} ]}})
		.addLov({name:"asgnName", dataIndex:"asgnName", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_DataSourcesAsgn_Lov", selectOnFocus:true}})
		.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.ad + "AccessControlAsgn_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_AccessControlAsgn_Dc$CtxEditList",
	_noImport_: true,
	_noExport_: true,
	_bulkEditFields_: ["queryAllowed","updateAllowed"],

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addLov({name:"asgnName", dataIndex:"asgnName", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_DataSourcesAsgn_Lov", selectOnFocus:true}})
		.addBooleanColumn({name:"queryAllowed", dataIndex:"queryAllowed"})
		.addBooleanColumn({name:"updateAllowed", dataIndex:"updateAllowed"})
		.addTextColumn({name:"accessControlId", dataIndex:"accessControlId", hidden:true, width:100, noEdit: true})
		.addDefaults();
	}
});

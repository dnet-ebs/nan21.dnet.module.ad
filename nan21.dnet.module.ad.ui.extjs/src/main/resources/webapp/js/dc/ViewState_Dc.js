/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "ViewState_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "ViewState_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "ViewState_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_ViewState_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"cmp", dataIndex:"cmp"})
		.addCombo({ xtype:"combo", name:"cmpType", dataIndex:"cmpType", store:[ "frame-dcgrid", "frame-dcegrid"]})
		
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
		.addChildrenTo("col1", ["name"])
		.addChildrenTo("col2", ["cmpType", "cmp"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.ad + "ViewState_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_ViewState_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:150})
		.addTextColumn({ name:"cmpType", dataIndex:"cmpType", width:120})
		.addTextColumn({ name:"cmp", dataIndex:"cmp", width:400})
		.addTextColumn({ name:"value", dataIndex:"value", hidden:true, width:200})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Value ================= */

Ext.define(Dnet.ns.ad + "ViewState_Dc$Value" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_ViewState_Dc$Value",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addDisplayFieldText({ name:"value", dataIndex:"value"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout:"form", defaults:{labelAlign:"top"}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["value"]);
	}
});

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "JobContext_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "JobContext_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "JobContext_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_JobContext_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"id", dataIndex:"id"})
		.addLov({name:"jobName", dataIndex:"jobName", xtype:"ad_Jobs_Lov"})
		.addTextField({ name:"name", dataIndex:"name"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:250, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["jobName"])
		.addChildrenTo("col2", ["name"])
		.addChildrenTo("col3", ["id"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.ad + "JobContext_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_JobContext_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"name", dataIndex:"name", width:200})
		.addTextColumn({name:"description", dataIndex:"description", width:200})
		.addLov({name:"jobName", dataIndex:"jobName", xtype:"gridcolumn", width:200, 
			editor:{xtype:"ad_Jobs_Lov", selectOnFocus:true, noUpdate:true}})
		.addDefaults();
	}
});

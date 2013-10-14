/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "FrameExtension_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "FrameExtension_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "FrameExtension_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_FrameExtension_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"frame", dataIndex:"frame"})
		.addTextField({ name:"fileLocation", dataIndex:"fileLocation"})
		.addBooleanField({ name:"relativePath", dataIndex:"relativePath"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["frame", "fileLocation"])
		.addChildrenTo("col2", ["relativePath", "active"]);
	}
});

/* ================= EDIT-GRID: EditList ================= */

Ext.define(Dnet.ns.ad + "FrameExtension_Dc$EditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_FrameExtension_Dc$EditList",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"frame", dataIndex:"frame", width:200})
		.addNumberColumn({name:"sequenceNo", dataIndex:"sequenceNo", align:"right" })
		.addTextColumn({name:"fileLocation", dataIndex:"fileLocation", width:200})
		.addBooleanColumn({name:"relativePath", dataIndex:"relativePath"})
		.addBooleanColumn({name:"active", dataIndex:"active"})
		.addTextColumn({name:"notes", dataIndex:"notes", width:200})
		.addDefaults();
	}
});

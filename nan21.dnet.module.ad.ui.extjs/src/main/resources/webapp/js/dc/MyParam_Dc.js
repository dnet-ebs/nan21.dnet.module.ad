/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "MyParam_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	paramModel: Dnet.ns.ad + "MyParam_DsParam",
	recordModel: Dnet.ns.ad + "MyParam_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "MyParam_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_MyParam_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addLov({name:"code", dataIndex:"code", xtype:"ad_Params_Lov", caseRestriction:"uppercase"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["code"])
		.addChildrenTo("col2", ["name"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.ad + "MyParam_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_MyParam_Dc$List",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:200})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"description", dataIndex:"description", width:300})
		.addTextColumn({ name:"defaultValue", dataIndex:"defaultValue", width:200})
		.addTextColumn({ name:"listOfValues", dataIndex:"listOfValues", width:200})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addDefaults();
	}
});

/* ================= EDIT FORM: InitValuesDateRange ================= */

Ext.define(Dnet.ns.ad + "MyParam_Dc$InitValuesDateRange" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_MyParam_Dc$InitValuesDateRange",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addDateField({name:"validFrom", paramIndex:"validFrom"})
		.addDateField({name:"validTo", paramIndex:"validTo"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["validFrom", "validTo"]);
	}
});

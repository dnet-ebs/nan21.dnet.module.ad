/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "JobLog_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	filterModel: Dnet.ns.ad + "JobLog_DsFilter",
	recordModel: Dnet.ns.ad + "JobLog_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "JobLog_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_JobLog_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"id", dataIndex:"id"})
		.addLov({name:"jobName", dataIndex:"jobName", xtype:"ad_Jobs_Lov"})
		.addLov({name:"jobContext", dataIndex:"jobContext", xtype:"ad_JobContexts_Lov",
			retFieldMapping: [{lovField:"id", dsField: "jobContextId"} ],
			filterFieldMapping: [{lovField:"jobName", dsField: "jobName"} ]})
		.addLov({name:"jobTimer", dataIndex:"jobTimer", xtype:"ad_JobTimers_Lov",
			retFieldMapping: [{lovField:"id", dsField: "jobTimerId"} ],
			filterFieldMapping: [{lovField:"jobContextId", dsField: "jobContextId"} ]})
		.addDateField({name:"startTime_From", dataIndex:"startTime_From", emptyText:"From" })
		.addDateField({name:"startTime_To", dataIndex:"startTime_To", emptyText:"To" })
		.addFieldContainer({name: "startTime"})
			.addChildrenTo("startTime",["startTime_From", "startTime_To"])
		.addDateField({name:"endTime_From", dataIndex:"endTime_From", emptyText:"From" })
		.addDateField({name:"endTime_To", dataIndex:"endTime_To", emptyText:"To" })
		.addFieldContainer({name: "endTime"})
			.addChildrenTo("endTime",["endTime_From", "endTime_To"])
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:280, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:300, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["jobName", "jobContext"])
		.addChildrenTo("col2", ["jobTimer", "id"])
		.addChildrenTo("col3", ["startTime", "endTime"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.ad + "JobLog_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_JobLog_Dc$List",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"jobName", dataIndex:"jobName", width:200})
		.addTextColumn({ name:"jobContext", dataIndex:"jobContext", width:200})
		.addTextColumn({ name:"jobTimer", dataIndex:"jobTimer", width:200})
		.addDateColumn({ name:"startTime", dataIndex:"startTime", _mask_: Masks.DATETIME})
		.addDateColumn({ name:"endTime", dataIndex:"endTime", _mask_: Masks.DATETIME})
		.addTextColumn({ name:"jobContextId", dataIndex:"jobContextId", hidden:true, width:100})
		.addTextColumn({ name:"jobTimerId", dataIndex:"jobTimerId", hidden:true, width:100})
		.addDefaults();
	}
});

/* ================= GRID: CtxListJob ================= */

Ext.define(Dnet.ns.ad + "JobLog_Dc$CtxListJob" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_JobLog_Dc$CtxListJob",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"jobContext", dataIndex:"jobContext", width:200})
		.addDateColumn({ name:"startTime", dataIndex:"startTime", _mask_: Masks.DATETIME})
		.addDateColumn({ name:"endTime", dataIndex:"endTime", _mask_: Masks.DATETIME})
		.addDefaults();
	}
});

/* ================= GRID: CtxListJobContext ================= */

Ext.define(Dnet.ns.ad + "JobLog_Dc$CtxListJobContext" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_JobLog_Dc$CtxListJobContext",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addDateColumn({ name:"startTime", dataIndex:"startTime", width:150, _mask_: Masks.DATETIME})
		.addDateColumn({ name:"endTime", dataIndex:"endTime", width:150, _mask_: Masks.DATETIME})
		.addDefaults();
	}
});

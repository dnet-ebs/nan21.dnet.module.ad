/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "JobContextParam_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "JobContextParam_Ds"
});

/* ================= EDIT-GRID: CtxEditList ================= */

Ext.define(Dnet.ns.ad + "JobContextParam_Dc$CtxEditList" , {
	extend: "dnet.core.dc.view.AbstractDcvEditableGrid",
	alias: "widget.ad_JobContextParam_Dc$CtxEditList",
	_noImport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()	
		.addTextColumn({name:"paramName", dataIndex:"paramName", width:200, noEdit: true})
		.addTextColumn({name:"dataType", dataIndex:"dataType", width:150, noEdit: true})
		.addTextColumn({name:"value", dataIndex:"value", width:200})
		.addDefaults();
	}
});

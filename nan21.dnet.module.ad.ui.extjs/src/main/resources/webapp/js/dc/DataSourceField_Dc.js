/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "DataSourceField_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "DataSourceField_Ds"
});

/* ================= GRID: CtxList ================= */

Ext.define(Dnet.ns.ad + "DataSourceField_Dc$CtxList" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_DataSourceField_Dc$CtxList",
	_noImport_: true,
	_noExport_: true,

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"dataType", dataIndex:"dataType", width:150})
		.addDefaults();
	}
});

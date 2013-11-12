/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "DbChangeLog_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	filterModel: Dnet.ns.ad + "DbChangeLog_DsFilter",
	recordModel: Dnet.ns.ad + "DbChangeLog_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "DbChangeLog_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_DbChangeLog_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"author", dataIndex:"author"})
		.addTextField({ name:"liquibase", dataIndex:"liquibase"})
		.addTextField({ name:"filename", dataIndex:"filename"})
		.addTextField({ name:"description", dataIndex:"description"})
		.addTextField({ name:"txid", dataIndex:"txid", width:100})
		.addDateField({name:"dateExecuted_From", dataIndex:"dateExecuted_From", emptyText:"From" })
		.addDateField({name:"dateExecuted_To", dataIndex:"dateExecuted_To", emptyText:"To" })
		.addFieldContainer({name: "dateExecuted"})
			.addChildrenTo("dateExecuted",["dateExecuted_From", "dateExecuted_To"])
		.addNumberField({name:"orderExecuted_From", dataIndex:"orderExecuted_From", emptyText:"From" })
		.addNumberField({name:"orderExecuted_To", dataIndex:"orderExecuted_To", emptyText:"To" })
		.addFieldContainer({name: "orderExecuted"})
			.addChildrenTo("orderExecuted",["orderExecuted_From", "orderExecuted_To"])
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:210, layout:"form"})
		.addPanel({ name:"col2", width:210, layout:"form"})
		.addPanel({ name:"col3", width:290, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["liquibase", "txid", "author"])
		.addChildrenTo("col2", ["filename", "description"])
		.addChildrenTo("col3", ["dateExecuted", "orderExecuted"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.ad + "DbChangeLog_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_DbChangeLog_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"liquibase", dataIndex:"liquibase", width:80})
		.addTextColumn({ name:"txid", dataIndex:"txid", width:100})
		.addTextColumn({ name:"author", dataIndex:"author", width:100})
		.addTextColumn({ name:"filename", dataIndex:"filename", width:200})
		.addTextColumn({ name:"description", dataIndex:"description", width:200})
		.addDateColumn({ name:"dateExecuted", dataIndex:"dateExecuted", _mask_: Masks.DATETIME})
		.addNumberColumn({ name:"orderExecuted", dataIndex:"orderExecuted"})
		.addTextColumn({ name:"tag", dataIndex:"tag", width:200})
		.addTextColumn({ name:"md5sum", dataIndex:"md5sum", width:200})
		.addTextColumn({ name:"comments", dataIndex:"comments", hidden:true, width:200})
		.addDefaults();
	}
});

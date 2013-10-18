/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "MyUser_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "MyUser_Ds"
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.ad + "MyUser_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_MyUser_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"code", dataIndex:"code", noEdit:true , caseRestriction:"uppercase"})
		.addTextField({ name:"name", dataIndex:"name", noEdit:true })
		.addTextField({ name:"email", dataIndex:"email"})
		.addTextField({ name:"loginName", dataIndex:"loginName"})
		.addCombo({ xtype:"combo", name:"decimalSeparator", dataIndex:"decimalSeparator", store:[ ".", ","]})
		.addCombo({ xtype:"combo", name:"thousandSeparator", dataIndex:"thousandSeparator", store:[ ".", ","]})
		.addLov({name:"dateFormat", dataIndex:"dateFormat", xtype:"ad_DateFormats_Lov",
			retFieldMapping: [{lovField:"id", dsField: "dateFormatId"} ]})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:350, layout:"form"})
		.addPanel({ name:"col2", title:"Regional settings", width:280, layout:"form", xtype:"fieldset", border:true, collapsible:false});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "code", "loginName", "email"])
		.addChildrenTo("col2", ["dateFormat", "decimalSeparator", "thousandSeparator"]);
	}
});

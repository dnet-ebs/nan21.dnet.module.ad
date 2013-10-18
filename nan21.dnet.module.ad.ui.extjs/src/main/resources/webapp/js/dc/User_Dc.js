/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "User_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	paramModel: Dnet.ns.ad + "User_DsParam",
	recordModel: Dnet.ns.ad + "User_Ds"
});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "User_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_User_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name"})
		.addTextField({ name:"loginName", dataIndex:"loginName"})
		.addLov({name:"code", dataIndex:"code", xtype:"ad_Users_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addLov({name:"withRole", paramIndex:"withRole", xtype:"ad_Roles_Lov",
			retFieldMapping: [{lovField:"id", dsParam: "withRoleId"} ]})
		.addLov({name:"inGroup", paramIndex:"inGroup", xtype:"ad_UserGroups_Lov",
			retFieldMapping: [{lovField:"id", dsParam: "inGroupId"} ]})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"locked", dataIndex:"locked"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:280, layout:"form"})
		.addPanel({ name:"col2", width:250, layout:"form"})
		.addPanel({ name:"col3", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["code", "name", "loginName"])
		.addChildrenTo("col2", ["withRole", "inGroup"])
		.addChildrenTo("col3", ["active", "locked"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.ad + "User_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_User_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:120})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"loginName", dataIndex:"loginName", width:200})
		.addTextColumn({ name:"dateFormat", dataIndex:"dateFormat", width:200})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addBooleanColumn({ name:"locked", dataIndex:"locked"})
		.addTextColumn({ name:"decimalSeparator", dataIndex:"decimalSeparator", hidden:true, width:50})
		.addTextColumn({ name:"thousandSeparator", dataIndex:"thousandSeparator", hidden:true, width:50})
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.ad + "User_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_User_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"code", dataIndex:"code", noUpdate:true, allowBlank:false, caseRestriction:"uppercase"})
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"loginName", dataIndex:"loginName", allowBlank:false})
		.addTextField({ name:"email", dataIndex:"email"})
		.addTextArea({ name:"notes", dataIndex:"notes", height:60})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addBooleanField({ name:"locked", dataIndex:"locked"})
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
		.addChildrenTo("col1", ["name", "code", "loginName", "email", "notes", "active", "locked"])
		.addChildrenTo("col2", ["dateFormat", "decimalSeparator", "thousandSeparator"]);
	}
});

/* ================= EDIT FORM: ChangePasswordForm ================= */

Ext.define(Dnet.ns.ad + "User_Dc$ChangePasswordForm" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_User_Dc$ChangePasswordForm",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"newPassword", paramIndex:"newPassword", allowBlank:false, inputType:"password"})
		.addTextField({ name:"confirmPassword", paramIndex:"confirmPassword", allowBlank:false, inputType:"password"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, width:350, layout:"form"});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["newPassword", "confirmPassword"]);
	}
});

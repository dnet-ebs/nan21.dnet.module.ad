/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "Client_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	paramModel: Dnet.ns.ad + "Client_DsParam",
	recordModel: Dnet.ns.ad + "Client_Ds",
			
			/* ================ Business functions ================ */
	
	initNewRecordInstance: function(r) {
		
		this.setParamValue("adminUserCode","ADMIN");
		this.setParamValue("adminUserName","Administrator");
		this.setParamValue("adminUserLogin","admin");
	}

});

/* ================= FILTER FORM: Filter ================= */			

Ext.define(Dnet.ns.ad + "Client_Dc$Filter" , {
	extend: "dnet.core.dc.view.AbstractDcvFilterForm",
	alias: "widget.ad_Client_Dc$Filter",

	/**
	 * Components definition
	 */	
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addLov({name:"code", dataIndex:"code", xtype:"ad_Clients_Lov", caseRestriction:"uppercase",
			retFieldMapping: [{lovField:"id", dsField: "id"} ]})
		.addTextField({ name:"name", dataIndex:"name"})
		.addBooleanField({ name:"active", dataIndex:"active"})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:280, layout:"form"})
		.addPanel({ name:"col2", width:170, layout:"form"});
	},

	/**
	 * Combine the components
	 */				
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["code", "name"])
		.addChildrenTo("col2", ["active"]);
	}
});

/* ================= GRID: List ================= */

Ext.define(Dnet.ns.ad + "Client_Dc$List" , {
	extend: "dnet.core.dc.view.AbstractDcvGrid",
	alias: "widget.ad_Client_Dc$List",

	/**
	 * Columns definition
	 */
	_defineColumns_: function() {
		this._getBuilder_()
		.addTextColumn({ name:"code", dataIndex:"code", width:120})
		.addTextColumn({ name:"name", dataIndex:"name", width:200})
		.addTextColumn({ name:"notes", dataIndex:"notes", hidden:true, width:200})
		.addTextColumn({ name:"adminRole", dataIndex:"adminRole", hidden:true, width:50})
		.addBooleanColumn({ name:"active", dataIndex:"active"})
		.addTextColumn({ name:"workspacePath", dataIndex:"workspacePath", width:200})
		.addTextColumn({ name:"importPath", dataIndex:"importPath", width:200})
		.addTextColumn({ name:"exportPath", dataIndex:"exportPath", width:200})
		.addTextColumn({ name:"tempPath", dataIndex:"tempPath", width:200})
		.addDefaults();
	}
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.ad + "Client_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_Client_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"code", dataIndex:"code", allowBlank:false, caseRestriction:"uppercase"})
		.addTextArea({ name:"notes", dataIndex:"notes", height:60})
		.addTextField({ name:"adminRole", dataIndex:"adminRole", noEdit:true , maxLength:32})
		.addBooleanField({ name:"active", dataIndex:"active"})
		.addTextField({ name:"workspacePath", dataIndex:"workspacePath", allowBlank:false})
		.addTextField({ name:"importPath", dataIndex:"importPath", allowBlank:false})
		.addTextField({ name:"exportPath", dataIndex:"exportPath", allowBlank:false})
		.addTextField({ name:"tempPath", dataIndex:"tempPath", allowBlank:false})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:350, layout:"form"})
		.addPanel({ name:"col2", title:"Working directories", width:550, layout:"form", xtype:"fieldset", border:true, collapsible:true, defaults:{labelAlign:"right", labelWidth:120}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2"])
		.addChildrenTo("col1", ["name", "code", "notes", "adminRole", "active"])
		.addChildrenTo("col2", ["workspacePath", "importPath", "exportPath", "tempPath"]);
	}
});

/* ================= EDIT FORM: Create ================= */

Ext.define(Dnet.ns.ad + "Client_Dc$Create" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_Client_Dc$Create",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", allowBlank:false})
		.addTextField({ name:"code", dataIndex:"code", allowBlank:false, caseRestriction:"uppercase"})
		.addTextArea({ name:"notes", dataIndex:"notes", height:60})
		.addTextField({ name:"adminRole", dataIndex:"adminRole", noEdit:true , maxLength:32})
		.addTextField({ name:"adminUserCode", paramIndex:"adminUserCode", allowBlank:false, caseRestriction:"uppercase"})
		.addTextField({ name:"adminUserName", paramIndex:"adminUserName", allowBlank:false})
		.addTextField({ name:"adminUserLogin", paramIndex:"adminUserLogin", allowBlank:false})
		.addTextField({ name:"adminPassword", paramIndex:"adminPassword", allowBlank:false, inputType:"password"})
		.addTextField({ name:"initFileLocation", paramIndex:"initFileLocation", allowBlank:false})
		.addTextField({ name:"workspacePath", dataIndex:"workspacePath", allowBlank:false,listeners:{
			change:{scope:this, fn:this.createPathsFromWorkspace}
		}})
		.addTextField({ name:"importPath", dataIndex:"importPath", allowBlank:false})
		.addTextField({ name:"exportPath", dataIndex:"exportPath", allowBlank:false})
		.addTextField({ name:"tempPath", dataIndex:"tempPath", allowBlank:false})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:300, layout:"form"})
		.addPanel({ name:"col2", title:"Administrator user", width:300, layout:"form", xtype:"fieldset", border:true, collapsible:true})
		.addPanel({ name:"col3", title:"Working directories", width:550, layout:"form", xtype:"fieldset", border:true, collapsible:true, defaults:{labelAlign:"right", labelWidth:120}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name", "code", "notes", "adminRole"])
		.addChildrenTo("col2", ["adminUserCode", "adminUserName", "adminUserLogin", "adminPassword"])
		.addChildrenTo("col3", ["initFileLocation", "workspacePath", "importPath", "exportPath", "tempPath"]);
	},
	/* ==================== Business functions ==================== */
	
	_shouldValidate_: function() {
		return this._controller_.record.phantom;
	},
	
	createPathsFromWorkspace: function() {
		
		var r = this._controller_.record;
		r.set("importPath",r.get("workspacePath") + "/import");
		r.set("exportPath",r.get("workspacePath") + "/export");
		r.set("tempPath",r.get("workspacePath") + "/temp");
	}
});

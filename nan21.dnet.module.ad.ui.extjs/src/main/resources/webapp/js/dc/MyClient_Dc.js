/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "MyClient_Dc" , {
	extend: "dnet.core.dc.AbstractDc",
	recordModel: Dnet.ns.ad + "MyClient_Ds"
});

/* ================= EDIT FORM: Edit ================= */

Ext.define(Dnet.ns.ad + "MyClient_Dc$Edit" , {
	extend: "dnet.core.dc.view.AbstractDcvEditForm",
	alias: "widget.ad_MyClient_Dc$Edit",

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		
		/* =========== controls =========== */
		.addTextField({ name:"name", dataIndex:"name", noEdit:true })
		.addTextField({ name:"code", dataIndex:"code", noEdit:true , caseRestriction:"uppercase"})
		.addTextField({ name:"workspacePath", dataIndex:"workspacePath", noEdit:true })
		.addTextField({ name:"importPath", dataIndex:"importPath", noEdit:true })
		.addTextField({ name:"exportPath", dataIndex:"exportPath", noEdit:true })
		.addTextField({ name:"tempPath", dataIndex:"tempPath", noEdit:true })
		.addTextField({ name:"adminRole", dataIndex:"adminRole", allowBlank:false, maxLength:32})
		.addDateField({name:"createdAt", dataIndex:"createdAt", noEdit:true })
		.addDateField({name:"modifiedAt", dataIndex:"modifiedAt", noEdit:true })
		.addTextField({ name:"createdBy", dataIndex:"createdBy", noEdit:true , maxLength:32})
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy", noEdit:true , maxLength:32})
		
		/* =========== containers =========== */
		.addPanel({ name:"main", autoScroll:true, layout: {type:"hbox", align:'top', pack:'start', defaultMargins: {right:5, left:5}},
		autoScroll:true, padding:"0 30 5 0"})
		.addPanel({ name:"col1", width:350, layout:"form"})
		.addPanel({ name:"col3", width:220, layout:"form"})
		.addPanel({ name:"col2", title:"Working directories", width:500, layout:"form", xtype:"fieldset", border:true, collapsible:false, defaults:{labelAlign:"right", labelWidth:120}});
	},

	/**
	 * Combine the components
	 */			
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["col1", "col2", "col3"])
		.addChildrenTo("col1", ["name", "code", "adminRole"])
		.addChildrenTo("col3", ["createdAt", "modifiedAt", "createdBy", "modifiedBy"])
		.addChildrenTo("col2", ["workspacePath", "importPath", "exportPath", "tempPath"]);
	}
});

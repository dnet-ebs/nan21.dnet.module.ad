/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.ad + "Client_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"workspacePath", type:"string"},
		{name:"importPath", type:"string"},
		{name:"exportPath", type:"string"},
		{name:"tempPath", type:"string"},
		{name:"adminRole", type:"string"},
		{name:"id", type:"string"},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"refid", type:"string"},
		{name:"entityAlias", type:"string"},
		{name:"entityFqn", type:"string"}
	]
});

Ext.define(Dnet.ns.ad + "Client_DsParam", {
	extend: 'Ext.data.Model',
	
	initParam: function() {
		this.set("adminUserCode", "ADMIN");
		this.set("adminUserName", "Administrator");
		this.set("adminUserLogin", "admin");
	},
	
	fields: [
		{name:"adminPassword", type:"string"},
		{name:"adminUserCode", type:"string"},
		{name:"adminUserLogin", type:"string"},
		{name:"adminUserName", type:"string"},
		{name:"initFileLocation", type:"string"}
	]
});

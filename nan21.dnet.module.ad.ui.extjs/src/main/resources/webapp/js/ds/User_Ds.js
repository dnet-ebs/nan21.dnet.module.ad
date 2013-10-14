/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.ad + "User_Ds", {
	extend: 'Ext.data.Model',
	
	validations: [
			{field: "name", type: 'presence'}
	],
	
	fields: [
		{name:"loginName", type:"string"},
		{name:"code", type:"string"},
		{name:"locked", type:"boolean"},
		{name:"email", type:"string"},
		{name:"decimalSeparator", type:"string"},
		{name:"thousandSeparator", type:"string"},
		{name:"dateFormatId", type:"string"},
		{name:"dateFormat", type:"string"},
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

Ext.define(Dnet.ns.ad + "User_DsParam", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"confirmPassword", type:"string"},
		{name:"inGroup", type:"string", forFilter:true},
		{name:"inGroupId", type:"string"},
		{name:"newPassword", type:"string"},
		{name:"withRole", type:"string", forFilter:true},
		{name:"withRoleId", type:"string"}
	]
});

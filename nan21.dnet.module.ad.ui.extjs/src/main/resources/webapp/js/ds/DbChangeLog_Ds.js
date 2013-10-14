/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.ad + "DbChangeLog_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"id", type:"string"},
		{name:"txid", type:"string"},
		{name:"author", type:"string"},
		{name:"filename", type:"string"},
		{name:"dateExecuted", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"orderExecuted", type:"int", useNull:true},
		{name:"md5sum", type:"string"},
		{name:"description", type:"string"},
		{name:"comments", type:"string"},
		{name:"tag", type:"string"},
		{name:"liquibase", type:"string"}
	]
});

Dnet.createFilterModelFromRecordModel({
	fields: [
		{name:"dateExecuted_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dateExecuted_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"orderExecuted_From",type:"int", useNull:true},
		{name:"orderExecuted_To",type:"int", useNull:true}
	],
	recordModelFqn: Dnet.ns.ad + "DbChangeLog_Ds"
});

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
	
Ext.define(Dnet.ns.ad + "MenuItemLov_Ds", {
	extend: 'Ext.data.Model',
	
	fields: [
		{name:"title", type:"string"},
		{name:"id", type:"string"},
		{name:"clientId", type:"string"},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"refid", type:"string"}
	]
});
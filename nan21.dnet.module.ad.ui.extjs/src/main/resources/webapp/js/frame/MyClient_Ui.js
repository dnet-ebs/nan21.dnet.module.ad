/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "MyClient_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.MyClient_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("client", Ext.create(Dnet.ns.ad + "MyClient_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFormView("client", {name:"clientEdit", xtype:"ad_MyClient_Dc$Edit"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["clientEdit"], ["center"])
		.addToolbarTo("main", "clientEditTlb");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("clientEditTlb", {dc: "client"})
			.addTitle().addSeparator().addSeparator()
			.addSave().addCancel()
			.addReports()
		.end();
	}

	
	,loadCurrentClient: function() {	
		this._getDc_("client").doQuery();
	}
	,_afterDefineDcs_: function() {
		this.loadCurrentClient();
	}
});

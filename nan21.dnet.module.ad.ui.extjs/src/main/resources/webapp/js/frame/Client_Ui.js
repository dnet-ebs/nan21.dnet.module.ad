/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "Client_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Client_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("client", Ext.create(Dnet.ns.ad + "Client_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("client", {name:"clientFilter", xtype:"ad_Client_Dc$Filter"})
		.addDcGridView("client", {name:"clientList", xtype:"ad_Client_Dc$List"})
		.addDcFormView("client", {name:"clientEdit", xtype:"ad_Client_Dc$Edit"})
		.addDcFormView("client", {name:"clientCreate", xtype:"ad_Client_Dc$Create"})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas3", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvas1", "canvas2", "canvas3"])
		.addChildrenTo("canvas1", ["clientFilter", "clientList"], ["north", "center"])
		.addChildrenTo("canvas2", ["clientEdit"], ["center"])
		.addChildrenTo("canvas3", ["clientCreate"], ["center"])
		.addToolbarTo("canvas1", "tlbClientList")
		.addToolbarTo("canvas2", "tlbClientEdit")
		.addToolbarTo("canvas3", "tlbClientCreate");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbClientList", {dc: "client"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew({autoEdit:"false",showView:"canvas3"})
			.addReports()
		.end()
		.beginToolbar("tlbClientEdit", {dc: "client"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew({autoEdit:"false",showView:"canvas3"}).addCancel().addPrevRec().addNextRec()
			.addReports()
		.end()
		.beginToolbar("tlbClientCreate", {dc: "client"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew({autoEdit:"false",showView:"canvas3"}).addCancel().addPrevRec().addNextRec()
			.addReports()
		.end();
	}

});

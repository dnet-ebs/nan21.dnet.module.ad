/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "ViewState_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.ViewState_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("viewstate", Ext.create(Dnet.ns.ad + "ViewState_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("viewstate", {name:"viewstateFilter", xtype:"ad_ViewState_Dc$Filter"})
		.addDcGridView("viewstate", {name:"viewstateList", xtype:"ad_ViewState_Dc$List"})
		.addDcFormView("viewstate", {name:"viewstateViewState", height:100, xtype:"ad_ViewState_Dc$Value"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["viewstateFilter", "viewstateList", "viewstateViewState"], ["north", "center", "south"])
		.addToolbarTo("main", "tlbViewstateList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbViewstateList", {dc: "viewstate"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addDeleteSelected()
			.addReports()
		.end();
	}

});

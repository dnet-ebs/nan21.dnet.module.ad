/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "AccessControlAsgn_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.AccessControlAsgn_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("asgnAccess", Ext.create(Dnet.ns.ad + "AccessControlAsgn_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("asgnAccess", {name:"asgnAccessFilter", height:80, xtype:"ad_AccessControlAsgn_Dc$Filter"})
		.addDcEditGridView("asgnAccess", {name:"asgnAccessEditList", xtype:"ad_AccessControlAsgn_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["asgnAccessFilter", "asgnAccessEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbAsgnAccessEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbAsgnAccessEditList", {dc: "asgnAccess"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});

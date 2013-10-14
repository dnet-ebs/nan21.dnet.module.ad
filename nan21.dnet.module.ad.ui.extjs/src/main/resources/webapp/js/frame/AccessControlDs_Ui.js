/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "AccessControlDs_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.AccessControlDs_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("dsAccess", Ext.create(Dnet.ns.ad + "AccessControlDs_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("dsAccess", {name:"dsAccessFilter", xtype:"ad_AccessControlDs_Dc$Filter"})
		.addDcEditGridView("dsAccess", {name:"dsAccessEditList", xtype:"ad_AccessControlDs_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["dsAccessFilter", "dsAccessEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbDsAccessEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbDsAccessEditList", {dc: "dsAccess"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});

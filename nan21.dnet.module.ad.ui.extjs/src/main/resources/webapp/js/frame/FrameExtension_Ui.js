/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "FrameExtension_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.FrameExtension_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("extensions", Ext.create(Dnet.ns.ad + "FrameExtension_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("extensions", {name:"extensionsFilter", xtype:"ad_FrameExtension_Dc$Filter"})
		.addDcEditGridView("extensions", {name:"extensionsEditList", xtype:"ad_FrameExtension_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["extensionsFilter", "extensionsEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbExtensionsEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbExtensionsEditList", {dc: "extensions"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end();
	}

});

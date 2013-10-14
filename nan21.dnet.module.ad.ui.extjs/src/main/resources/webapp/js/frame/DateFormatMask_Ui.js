/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "DateFormatMask_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.DateFormatMask_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("mask", Ext.create(Dnet.ns.ad + "DateFormatMask_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("mask", {name:"maskFilter", xtype:"ad_DateFormatMask_Dc$Filter"})
		.addDcEditGridView("mask", {name:"maskEditList", xtype:"ad_DateFormatMask_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["maskFilter", "maskEditList"], ["north", "center"])
		.addToolbarTo("main", "tlbMaskList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbMaskList", {dc: "mask"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addCancel()
			.addReports()
		.end();
	}

});

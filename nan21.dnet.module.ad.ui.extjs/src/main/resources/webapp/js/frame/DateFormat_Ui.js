/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "DateFormat_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.DateFormat_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("fmt", Ext.create(Dnet.ns.ad + "DateFormat_Dc" ,{multiEdit:true}))	
		.addDc("mask", Ext.create(Dnet.ns.ad + "DateFormatMask_Dc" ,{multiEdit:true}))
		.linkDc("mask", "fmt",{fetchMode:"auto",fields:[
			{childField:"dateFormatId", parentField:"id"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnSynchronize", disabled:true, handler: this.onBtnSynchronize,
				stateManager:{ name:"selected_one_clean", dc:"fmt" }, scope:this})
		.addDcFilterFormView("fmt", {name:"fmtFilter", xtype:"ad_DateFormat_Dc$Filter"})
		.addDcEditGridView("fmt", {name:"fmtEditList", xtype:"ad_DateFormat_Dc$EditList", frame:true})
		.addDcEditGridView("mask", {name:"maskEditList", height:280, xtype:"ad_DateFormatMask_Dc$CtxEditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["fmtFilter", "fmtEditList", "maskEditList"], ["north", "center", "south"])
		.addToolbarTo("main", "tlbFmtList")
		.addToolbarTo("maskEditList", "tlbMaskList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbFmtList", {dc: "fmt"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addReports()
		.end()
		.beginToolbar("tlbMaskList", {dc: "mask"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnSynchronize
	 */
	,onBtnSynchronize: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("mask").doQuery();
		};
		var o={
			name:"synchronizeMasks",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("fmt").doRpcData(o);
	}
});

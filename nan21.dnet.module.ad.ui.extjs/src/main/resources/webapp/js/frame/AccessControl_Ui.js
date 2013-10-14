/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "AccessControl_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.AccessControl_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("ctrl", Ext.create(Dnet.ns.ad + "AccessControl_Dc" ,{multiEdit:true}))	
		.addDc("dsAccess", Ext.create(Dnet.ns.ad + "AccessControlDs_Dc" ,{multiEdit:true}))	
		.addDc("asgnAccess", Ext.create(Dnet.ns.ad + "AccessControlAsgn_Dc" ,{multiEdit:true}))	
		.addDc("dsMtdAccess", Ext.create(Dnet.ns.ad + "AccessControlDsRpc_Dc" ,{multiEdit:true}))
		.linkDc("dsAccess", "ctrl",{fetchMode:"auto",fields:[
			{childField:"accessControlId", parentField:"id"}]}
		).linkDc("asgnAccess", "ctrl",{fetchMode:"auto",fields:[
			{childField:"accessControlId", parentField:"id"}]}
		).linkDc("dsMtdAccess", "ctrl",{fetchMode:"auto",fields:[
			{childField:"accessControlId", parentField:"id"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnAsgnRoleToAccessCtrl", disabled:true, handler: this.onBtnAsgnRoleToAccessCtrl,
				stateManager:{ name:"selected_one_clean", dc:"ctrl" }, scope:this})
		.addButton({name:"btnCopyRules", disabled:true, handler: this.onBtnCopyRules,
				stateManager:{ name:"selected_one_clean", dc:"ctrl" }, scope:this})
		.addButton({name:"btnCopyRulesExec", disabled:false, handler: this.onBtnCopyRulesExec, scope:this})
		.addButton({name:"btnShowUiAsgnRules", disabled:false, handler: this.onBtnShowUiAsgnRules, scope:this})
		.addButton({name:"btnShowUiDsRules", disabled:false, handler: this.onBtnShowUiDsRules, scope:this})
		.addButton({name:"btnShowUiServiceRules", disabled:false, handler: this.onBtnShowUiServiceRules, scope:this})
		.addDcFilterFormView("ctrl", {name:"privilegeFilter", xtype:"ad_AccessControl_Dc$Filter"})
		.addDcEditGridView("ctrl", {name:"privilegeEditList", width:600, xtype:"ad_AccessControl_Dc$EditList", frame:true})
		.addDcFormView("ctrl", {name:"privilegeCopyRules", xtype:"ad_AccessControl_Dc$CopyRulesFromSource"})
		.addDcEditGridView("dsAccess", {name:"dsAccessCtxEditList", _hasTitle_:true, xtype:"ad_AccessControlDs_Dc$CtxEditList", frame:true})
		.addDcEditGridView("asgnAccess", {name:"asgnAccessCtxEditList", _hasTitle_:true, xtype:"ad_AccessControlAsgn_Dc$CtxEditList", frame:true})
		.addDcEditGridView("dsMtdAccess", {name:"dsMtdAccessCtxEditList", _hasTitle_:true, xtype:"ad_AccessControlDsRpc_Dc$CtxEditList", frame:true})
		.addWindow({name:"wdwCopyRules", _hasTitle_:true, width:400, height:180, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("privilegeCopyRules")], 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnCopyRulesExec")]}]})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"detailTabs", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["privilegeFilter", "privilegeEditList", "detailTabs"], ["north", "west", "center"])
		.addChildrenTo("detailTabs", ["dsAccessCtxEditList", "asgnAccessCtxEditList", "dsMtdAccessCtxEditList"])
		.addToolbarTo("main", "tlbCtrlEditList")
		.addToolbarTo("dsAccessCtxEditList", "tlbDsAccessCtxEditList")
		.addToolbarTo("asgnAccessCtxEditList", "tlbAsgnAccessCtxEditList")
		.addToolbarTo("dsMtdAccessCtxEditList", "tlbDsMtdAccessCtxEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbCtrlEditList", {dc: "ctrl"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnAsgnRoleToAccessCtrl") ,this._elems_.get("btnCopyRules") ,this._elems_.get("btnShowUiDsRules") ,this._elems_.get("btnShowUiAsgnRules") ,this._elems_.get("btnShowUiServiceRules") ])
			.addReports()
		.end()
		.beginToolbar("tlbDsAccessCtxEditList", {dc: "dsAccess"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbAsgnAccessCtxEditList", {dc: "asgnAccess"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbDsMtdAccessCtxEditList", {dc: "dsMtdAccess"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnAsgnRoleToAccessCtrl
	 */
	,onBtnAsgnRoleToAccessCtrl: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "AccessControl_Role_Asgn$Ui" ,{dc: "ctrl", objectIdField: "id"});
	}
	
	/**
	 * On-Click handler for button btnCopyRules
	 */
	,onBtnCopyRules: function() {
		this._getWindow_("wdwCopyRules").show();
	}
	
	/**
	 * On-Click handler for button btnCopyRulesExec
	 */
	,onBtnCopyRulesExec: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getWindow_("wdwCopyRules").close();
			this._getDc_("dsAccess").doQuery();
			this._getDc_("asgnAccess").doQuery();
		};
		var o={
			name:"copyRulesFromAccessControl",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("ctrl").doRpcData(o);
	}
	
	/**
	 * On-Click handler for button btnShowUiAsgnRules
	 */
	,onBtnShowUiAsgnRules: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "AccessControlAsgn_Ui";
		getApplication().showFrameByName(bundle, frame);
	}
	
	/**
	 * On-Click handler for button btnShowUiDsRules
	 */
	,onBtnShowUiDsRules: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "AccessControlDs_Ui";
		getApplication().showFrameByName(bundle, frame);
	}
	
	/**
	 * On-Click handler for button btnShowUiServiceRules
	 */
	,onBtnShowUiServiceRules: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "AccessControlDsRpc_Ui";
		getApplication().showFrameByName(bundle, frame);
	}
});

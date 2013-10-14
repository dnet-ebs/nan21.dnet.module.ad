/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "User_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.User_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("usr", Ext.create(Dnet.ns.ad + "User_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnAsgnRoles", disabled:true, handler: this.onBtnAsgnRoles,
				stateManager:{ name:"record_is_clean", dc:"usr" }, scope:this})
		.addButton({name:"btnAsgnGroups", disabled:true, handler: this.onBtnAsgnGroups,
				stateManager:{ name:"record_is_clean", dc:"usr" }, scope:this})
		.addButton({name:"btnChangePassword", disabled:true, handler: this.onBtnChangePassword,
				stateManager:{ name:"record_is_clean", dc:"usr" }, scope:this})
		.addButton({name:"btnSavePassword", disabled:false, handler: this.onBtnSavePassword, scope:this})
		.addDcFilterFormView("usr", {name:"usrFilter", xtype:"ad_User_Dc$Filter"})
		.addDcGridView("usr", {name:"usrList", xtype:"ad_User_Dc$List"})
		.addDcFormView("usr", {name:"usrEdit", xtype:"ad_User_Dc$Edit"})
		.addDcFormView("usr", {name:"canvasPassword", preventHeader:true, isCanvas:true, xtype:"ad_User_Dc$ChangePasswordForm"})
		.addWindow({name:"wdwChangePassword", _hasTitle_:true, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("canvasPassword")], 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnSavePassword")]}]})
		.addPanel({name:"main", layout:"card", activeItem:0})
		.addPanel({name:"canvas1", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}})
		.addPanel({name:"canvas2", preventHeader:true, isCanvas:true, layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["canvas1", "canvas2"])
		.addChildrenTo("canvas1", ["usrFilter", "usrList"], ["north", "center"])
		.addChildrenTo("canvas2", ["usrEdit"], ["center"])
		.addToolbarTo("canvas1", "tlbUsrList")
		.addToolbarTo("canvas2", "tlbUsrEdit");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbUsrList", {dc: "usr"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addEdit().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbUsrEdit", {dc: "usr"})
			.addTitle().addSeparator().addSeparator()
			.addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnAsgnRoles") ,this._elems_.get("btnAsgnGroups") ,this._elems_.get("btnChangePassword") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnAsgnRoles
	 */
	,onBtnAsgnRoles: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "User_Role_Asgn$Ui" ,{dc: "usr", objectIdField: "id"});
	}
	
	/**
	 * On-Click handler for button btnAsgnGroups
	 */
	,onBtnAsgnGroups: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "User_UserGroup_Asgn$Ui" ,{dc: "usr", objectIdField: "id"});
	}
	
	/**
	 * On-Click handler for button btnChangePassword
	 */
	,onBtnChangePassword: function() {
		this._getWindow_("wdwChangePassword").show();
	}
	
	/**
	 * On-Click handler for button btnSavePassword
	 */
	,onBtnSavePassword: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getWindow_("wdwChangePassword").close();
		};
		var o={
			name:"changePassword",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("usr").doRpcData(o);
	}
});

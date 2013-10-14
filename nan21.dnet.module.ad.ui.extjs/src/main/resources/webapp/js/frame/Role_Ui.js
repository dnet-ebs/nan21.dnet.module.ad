/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "Role_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Role_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("rol", Ext.create(Dnet.ns.ad + "Role_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnAsgnRoleToUsers", disabled:true, handler: this.onBtnAsgnRoleToUsers,
				stateManager:{ name:"selected_one_clean", dc:"rol" }, scope:this})
		.addButton({name:"btnAsgnRoleToAccessCtrl", disabled:true, handler: this.onBtnAsgnRoleToAccessCtrl,
				stateManager:{ name:"selected_one_clean", dc:"rol" }, scope:this})
		.addButton({name:"btnAsgnRoleToMenuItem", disabled:true, handler: this.onBtnAsgnRoleToMenuItem,
				stateManager:{ name:"selected_one_clean", dc:"rol" }, scope:this})
		.addButton({name:"btnAsgnRoleToMenu", disabled:true, handler: this.onBtnAsgnRoleToMenu,
				stateManager:{ name:"selected_one_clean", dc:"rol" }, scope:this})
		.addDcFilterFormView("rol", {name:"rolFilter", height:80, xtype:"ad_Role_Dc$Filter"})
		.addDcEditGridView("rol", {name:"rolList", xtype:"ad_Role_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["rolFilter", "rolList"], ["north", "center"])
		.addToolbarTo("main", "tlbRolList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbRolList", {dc: "rol"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnAsgnRoleToUsers") ,this._elems_.get("btnAsgnRoleToAccessCtrl") ,this._elems_.get("btnAsgnRoleToMenu") ,this._elems_.get("btnAsgnRoleToMenuItem") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnAsgnRoleToUsers
	 */
	,onBtnAsgnRoleToUsers: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "Role_User_Asgn$Ui" ,{dc: "rol", objectIdField: "id"});
	}
	
	/**
	 * On-Click handler for button btnAsgnRoleToAccessCtrl
	 */
	,onBtnAsgnRoleToAccessCtrl: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "Role_AccessControl_Asgn$Ui" ,{dc: "rol", objectIdField: "id"});
	}
	
	/**
	 * On-Click handler for button btnAsgnRoleToMenuItem
	 */
	,onBtnAsgnRoleToMenuItem: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "Role_MenuItem_Asgn$Ui" ,{dc: "rol", objectIdField: "id"});
	}
	
	/**
	 * On-Click handler for button btnAsgnRoleToMenu
	 */
	,onBtnAsgnRoleToMenu: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "Role_Menu_Asgn$Ui" ,{dc: "rol", objectIdField: "id"});
	}
});

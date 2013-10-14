/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "UserGroup_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.UserGroup_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("dcGroup", Ext.create(Dnet.ns.ad + "UserGroup_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnAsgnUsers", disabled:true, handler: this.onBtnAsgnUsers,
				stateManager:{ name:"selected_one_clean", dc:"dcGroup" }, scope:this})
		.addDcFilterFormView("dcGroup", {name:"filterGroup", height:80, xtype:"ad_UserGroup_Dc$Filter"})
		.addDcEditGridView("dcGroup", {name:"elistGroup", xtype:"ad_UserGroup_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["filterGroup", "elistGroup"], ["north", "center"])
		.addToolbarTo("main", "tlbGroupEditList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbGroupEditList", {dc: "dcGroup"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnAsgnUsers") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnAsgnUsers
	 */
	,onBtnAsgnUsers: function() {
		this._showAsgnWindow_(Dnet.ns.ad + "UserGroup_User_Asgn$Ui" ,{dc: "dcGroup", objectIdField: "id"});
	}
});

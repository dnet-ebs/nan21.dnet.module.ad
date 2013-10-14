/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "MyUser_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.MyUser_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("usr", Ext.create(Dnet.ns.ad + "MyUser_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFormView("usr", {name:"usrEdit", xtype:"ad_MyUser_Dc$Edit"})
		.addPanel({name:"main", layout:"fit"});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["usrEdit"])
		.addToolbarTo("main", "tlbUsrEdit");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbUsrEdit", {dc: "usr"})
			.addTitle().addSeparator().addSeparator()
			.addSave().addCancel()
			.addReports()
		.end();
	}

	
	,loadCurrentUser: function() {
		
		  		this._getDc_("usr").doQuery();
	}
	,_afterDefineDcs_: function() {
		this.loadCurrentUser();
	}
});

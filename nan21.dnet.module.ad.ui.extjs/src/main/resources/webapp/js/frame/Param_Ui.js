/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "Param_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.Param_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("sysparam", Ext.create(Dnet.ns.ad + "Param_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnSynchronize", iconCls:"icon-action-synchronize", disabled:false, handler: this.onBtnSynchronize, scope:this})
		.addDcFilterFormView("sysparam", {name:"sysparamFilter", xtype:"ad_Param_Dc$Filter"})
		.addDcGridView("sysparam", {name:"sysparamList", xtype:"ad_Param_Dc$List"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["sysparamFilter", "sysparamList"], ["north", "center"])
		.addToolbarTo("main", "tlbSysparamList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbSysparamList", {dc: "sysparam"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnSynchronize") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnSynchronize
	 */
	,onBtnSynchronize: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("sysparam").doQuery();
		};
		var o={
			name:"synchronizeCatalog",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("sysparam").doRpcFilter(o);
	}
	
	,_afterDefineElements_: function() {
		
		if (!getApplication().getSession().user.systemUser) {
		         this._getBuilder_()
		    .change("btnSynchronize", {disabled: true});
		}
	}
});

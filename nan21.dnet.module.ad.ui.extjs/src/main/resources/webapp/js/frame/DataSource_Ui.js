/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "DataSource_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.DataSource_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("ds", Ext.create(Dnet.ns.ad + "DataSource_Dc" ,{}))	
		.addDc("fields", Ext.create(Dnet.ns.ad + "DataSourceField_Dc" ,{}))	
		.addDc("rpcs", Ext.create(Dnet.ns.ad + "DataSourceRpc_Dc" ,{}))
		.linkDc("fields", "ds",{fields:[
			{childField:"dataSourceId", parentField:"id"}]}
		).linkDc("rpcs", "ds",{fields:[
			{childField:"dataSourceId", parentField:"id"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnSynchronize", iconCls:"icon-action-synchronize", disabled:false, handler: this.onBtnSynchronize, scope:this})
		.addButton({name:"btnInfo", iconCls:"icon-action-view", disabled:true, handler: this.showDsInfo,
				stateManager:{ name:"selected_one", dc:"ds" , and: function(dc) {return ( ! dc.getRecord().get('isAsgn') );}}, scope:this})
		.addDcFilterFormView("ds", {name:"dsFilter", xtype:"ad_DataSource_Dc$Filter"})
		.addDcGridView("ds", {name:"dsList", xtype:"ad_DataSource_Dc$List"})
		.addDcGridView("fields", {name:"fieldsList", _hasTitle_:true, xtype:"ad_DataSourceField_Dc$CtxList"})
		.addDcGridView("rpcs", {name:"rpcsList", _hasTitle_:true, xtype:"ad_DataSourceRpc_Dc$CtxList"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"panelDetails", width:450, layout:"accordion", activeItem:0});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["dsFilter", "dsList", "panelDetails"], ["north", "center", "east"])
		.addChildrenTo("panelDetails", ["fieldsList", "rpcsList"])
		.addToolbarTo("main", "tlbDsList")
		.addToolbarTo("fieldsList", "tlbFieldsList")
		.addToolbarTo("rpcsList", "tlbRpcsList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbDsList", {dc: "ds"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnSynchronize") ,this._elems_.get("btnInfo") ])
			.addReports()
		.end()
		.beginToolbar("tlbFieldsList", {dc: "fields"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbRpcsList", {dc: "rpcs"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnSynchronize
	 */
	,onBtnSynchronize: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("ds").doQuery();
		};
		var o={
			name:"synchronizeCatalog",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("ds").doRpcFilter(o);
	}
	
	,_afterDefineElements_: function() {
		
		if (!getApplication().getSession().user.systemUser) {
		         this._getBuilder_()
		    .change("btnSynchronize", {disabled: true});
		}
	}
	
	,showDsInfo: function() {
		
		var rd = this._getDc_("ds").getRecord(); 
		var w=window.open( Dnet.dsAPI(rd.get("name"),"html").info ,"DataSourceInfo","width=600,height=500,scrollbars=yes");
		w.focus();
	}
});

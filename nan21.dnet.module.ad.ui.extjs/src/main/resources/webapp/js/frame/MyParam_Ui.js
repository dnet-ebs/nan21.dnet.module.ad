/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "MyParam_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.MyParam_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("param", Ext.create(Dnet.ns.ad + "MyParam_Dc" ,{}))	
		.addDc("val", Ext.create(Dnet.ns.ad + "ParamValue_Dc" ,{multiEdit:true}))
		.linkDc("val", "param",{fields:[
			{childField:"sysParam", parentField:"code"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnPublish", disabled:false, handler: this.onBtnPublish, scope:this})
		.addButton({name:"btnShowValuesFrame", disabled:false, handler: this.onBtnShowValuesFrame, scope:this})
		.addButton({name:"btnInitVal", disabled:true, handler: this.onBtnInitVal,
				stateManager:{ name:"selected_not_zero", dc:"param" }, scope:this})
		.addButton({name:"btnOk", disabled:false, handler: this.onBtnOk, scope:this})
		.addDcFilterFormView("param", {name:"paramFilter", xtype:"ad_MyParam_Dc$Filter"})
		.addDcGridView("param", {name:"paramList", xtype:"ad_MyParam_Dc$List"})
		.addDcFormView("param", {name:"initvalForm", xtype:"ad_MyParam_Dc$InitValuesDateRange"})
		.addDcEditGridView("val", {name:"valList", height:200, xtype:"ad_ParamValue_Dc$CtxEditList", frame:true})
		.addWindow({name:"wdwInitVal", _hasTitle_:true, width:350, height:150, closeAction:'hide', resizable:true, layout:"fit", modal:true,
			items:[this._elems_.get("initvalForm")], 
					dockedItems:[{xtype:"toolbar", ui:"footer", dock:'bottom', weight:-1,
						items:[ this._elems_.get("btnOk")]}]})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["paramFilter", "paramList", "valList"], ["north", "center", "south"])
		.addToolbarTo("main", "tlbParamList")
		.addToolbarTo("valList", "tlbValList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbParamList", {dc: "param"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnPublish") ,this._elems_.get("btnInitVal") ,this._elems_.get("btnShowValuesFrame") ])
			.addReports()
		.end()
		.beginToolbar("tlbValList", {dc: "val"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnPublish
	 */
	,onBtnPublish: function() {
		var o={
			name:"publishValues",
			modal:true
		};
		this._getDc_("val").doRpcFilter(o);
	}
	
	/**
	 * On-Click handler for button btnShowValuesFrame
	 */
	,onBtnShowValuesFrame: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "ParamValue_Ui";
		getApplication().showFrameByName(bundle, frame);
	}
	
	/**
	 * On-Click handler for button btnInitVal
	 */
	,onBtnInitVal: function() {
		this._getWindow_("wdwInitVal").show();
	}
	
	/**
	 * On-Click handler for button btnOk
	 */
	,onBtnOk: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getWindow_("wdwInitVal").close();
			this._getDc_("val").doQuery();
		};
		var o={
			name:"createInitialValues",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("param").doRpcDataList(o);
	}
});

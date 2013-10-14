/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "ParamValue_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.ParamValue_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("val", Ext.create(Dnet.ns.ad + "ParamValue_Dc" ,{multiEdit:true}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnPublish", disabled:false, handler: this.onBtnPublish, scope:this})
		.addButton({name:"btnShowParamsFrame", disabled:false, handler: this.onBtnShowParamsFrame, scope:this})
		.addDcFilterFormView("val", {name:"valFilter", xtype:"ad_ParamValue_Dc$Filter"})
		.addDcEditGridView("val", {name:"valList", xtype:"ad_ParamValue_Dc$EditList", frame:true})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["valFilter", "valList"], ["north", "center", "south"])
		.addToolbarTo("main", "tlbValList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbValList", {dc: "val"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnPublish") ,this._elems_.get("btnShowParamsFrame") ])
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
	 * On-Click handler for button btnShowParamsFrame
	 */
	,onBtnShowParamsFrame: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "MyParam_Ui";
		getApplication().showFrameByName(bundle, frame);
	}
});

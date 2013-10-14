/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "JobContext_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.JobContext_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("job", Ext.create(Dnet.ns.ad + "JobContext_Dc" ,{multiEdit:true}))	
		.addDc("params", Ext.create(Dnet.ns.ad + "JobContextParam_Dc" ,{multiEdit:true}))	
		.addDc("schedule", Ext.create(Dnet.ns.ad + "JobTimer_Dc" ,{}))	
		.addDc("log", Ext.create(Dnet.ns.ad + "JobLog_Dc" ,{}))
		.linkDc("params", "job",{fields:[
			{childField:"jobContextId", parentField:"id"}]}
		).linkDc("schedule", "job",{fields:[
			{childField:"jobContextId", parentField:"id"}]}
		).linkDc("log", "job",{fields:[
			{childField:"jobContextId", parentField:"id"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnShowLog", disabled:true, handler: this.onBtnShowLog,
				stateManager:{ name:"selected_not_zero", dc:"log" }, scope:this})
		.addButton({name:"btnSyncParams", disabled:true, handler: this.onBtnSyncParams,
				stateManager:{ name:"selected_not_zero", dc:"job" }, scope:this})
		.addDcFilterFormView("job", {name:"jobFilter", xtype:"ad_JobContext_Dc$Filter"})
		.addDcEditGridView("job", {name:"jobEditList", xtype:"ad_JobContext_Dc$EditList", frame:true})
		.addDcEditGridView("params", {name:"paramsEditList", _hasTitle_:true, xtype:"ad_JobContextParam_Dc$CtxEditList", frame:true})
		.addDcGridView("schedule", {name:"scheduleEditList", _hasTitle_:true, xtype:"ad_JobTimer_Dc$CtxListJobContext"})
		.addDcGridView("log", {name:"logList", _hasTitle_:true, xtype:"ad_JobLog_Dc$CtxListJobContext"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}})
		.addPanel({name:"theDetails", width:600, layout:"accordion", activeItem:0});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["jobFilter", "jobEditList", "theDetails"], ["north", "center", "east"])
		.addChildrenTo("theDetails", ["paramsEditList", "scheduleEditList", "logList"])
		.addToolbarTo("main", "tlbJobEditList")
		.addToolbarTo("paramsEditList", "tlbParamsEditList")
		.addToolbarTo("scheduleEditList", "tlbScheduleEditList")
		.addToolbarTo("logList", "tlbLogList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbJobEditList", {dc: "job"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnSyncParams") ])
			.addReports()
		.end()
		.beginToolbar("tlbParamsEditList", {dc: "params"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addSave().addCancel()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbScheduleEditList", {dc: "schedule"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addAutoLoad()
			.addReports()
		.end()
		.beginToolbar("tlbLogList", {dc: "log"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addDeleteSelected()
			.addSeparator().addAutoLoad()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnShowLog") ])
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnShowLog
	 */
	,onBtnShowLog: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "JobLog_Ui";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
				id: this._getDc_("log").getRecord().get("id")
			},
			callback: function (params) {
				this._when_called_to_view_(params);
			}
		});
	}
	
	/**
	 * On-Click handler for button btnSyncParams
	 */
	,onBtnSyncParams: function() {
		var successFn = function(dc,response,serviceName,specs) {
			this._getDc_("job").doQuery();
		};
		var o={
			name:"synchronizeParameters",
			callbacks:{
				successFn: successFn,
				successScope: this
			},
			modal:true
		};
		this._getDc_("job").doRpcDataList(o);
	}
	
	,_when_called_to_view_: function(params) {
		
		var job = this._getDc_("job");
		if (job.isDirty()) {
			this._alert_dirty_();
			return;
		}
		job.doClearQuery();	 
		
		job.setFilterValue("id", params.id );
		job.setFilterValue("name", params.name );
		job.setFilterValue("jobName", params.jobName );
		
		job.doQuery();
	}
});

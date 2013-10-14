/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "JobLog_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.JobLog_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("log", Ext.create(Dnet.ns.ad + "JobLog_Dc" ,{}))	
		.addDc("msg", Ext.create(Dnet.ns.ad + "JobLogMessage_Dc" ,{}))
		.linkDc("msg", "log",{fields:[
			{childField:"jobLogId", parentField:"id"}]}
		);
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addButton({name:"btnShowJob", disabled:true, handler: this.onBtnShowJob,
				stateManager:{ name:"selected_one", dc:"log" }, scope:this})
		.addButton({name:"btnShowJobContext", disabled:true, handler: this.onBtnShowJobContext,
				stateManager:{ name:"selected_one", dc:"log" }, scope:this})
		.addButton({name:"btnShowJobTimer", disabled:true, handler: this.onBtnShowJobTimer,
				stateManager:{ name:"selected_one", dc:"log" }, scope:this})
		.addDcFilterFormView("log", {name:"logFilter", xtype:"ad_JobLog_Dc$Filter"})
		.addDcGridView("log", {name:"logList", xtype:"ad_JobLog_Dc$List"})
		.addDcGridView("msg", {name:"msgList", width:500, xtype:"ad_JobLogMessage_Dc$List"})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["logFilter", "logList", "msgList"], ["north", "center", "east"])
		.addToolbarTo("main", "tlbLogList")
		.addToolbarTo("msgList", "tlbMsgList");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbLogList", {dc: "log"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addDeleteSelected()
			.addSeparator().addSeparator()
			.addButtons([this._elems_.get("btnShowJob") ,this._elems_.get("btnShowJobContext") ,this._elems_.get("btnShowJobTimer") ])
			.addReports()
		.end()
		.beginToolbar("tlbMsgList", {dc: "msg"})
			.addTitle().addSeparator().addSeparator()
			.addQuery()
			.addSeparator().addAutoLoad()
			.addReports()
		.end();
	}

	
	/**
	 * On-Click handler for button btnShowJob
	 */
	,onBtnShowJob: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "Job_Ui";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
				jobName: this._getDc_("log").getRecord().get("jobName")
			},
			callback: function (params) {
				this._when_called_to_view_(params);
			}
		});
	}
	
	/**
	 * On-Click handler for button btnShowJobContext
	 */
	,onBtnShowJobContext: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "JobContext_Ui";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
				id: this._getDc_("log").getRecord().get("jobContextId")
			},
			callback: function (params) {
				this._when_called_to_view_(params);
			}
		});
	}
	
	/**
	 * On-Click handler for button btnShowJobTimer
	 */
	,onBtnShowJobTimer: function() {
		var bundle = Dnet.bundle.ad;
		var frame = "JobTimer_Ui";
		getApplication().showFrame(frame,{
			url:Dnet.buildUiPath(bundle, frame, false),
			params: {
				id: this._getDc_("log").getRecord().get("jobTimerId")
			},
			callback: function (params) {
				this._when_called_to_view_(params);
			}
		});
	}
	
	,_when_called_to_view_: function(params) {
		
		var log = this._getDc_("log");
		if (log.isDirty()) {
			this._alert_dirty_();
			return;
		}
		log.doClearQuery();	 
		log.setFilterValue("id", params.id );
		log.doQuery();
	}
});

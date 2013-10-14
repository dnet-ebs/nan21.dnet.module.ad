/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "JobTimer_Ui" , {
	extend: "dnet.core.ui.AbstractUi",
	alias: "widget.JobTimer_Ui",
	
	/**
	 * Data-controls definition
	 */
	_defineDcs_: function() {
		this._getBuilder_()	
		.addDc("timer", Ext.create(Dnet.ns.ad + "JobTimer_Dc" ,{}))
		;
	},

	/**
	 * Components definition
	 */
	_defineElements_: function() {
		this._getBuilder_()
		.addDcFilterFormView("timer", {name:"timerFilter", xtype:"ad_JobTimer_Dc$Filter"})
		.addDcGridView("timer", {name:"timerList", xtype:"ad_JobTimer_Dc$List"})
		.addDcFormView("timer", {name:"timerEdit", width:500, xtype:"ad_JobTimer_Dc$Edit", collapsible:true
		})
		.addPanel({name:"main", layout:"border", defaults:{split:true}});
	},
	
	/**
	 * Combine the components
	 */
	_linkElements_: function() {
		this._getBuilder_()
		.addChildrenTo("main", ["timerFilter", "timerList", "timerEdit"], ["north", "center", "east"])
		.addToolbarTo("main", "tlbTimerList")
		.addToolbarTo("timerEdit", "tlbTimerEdit");
	},
	
	/**
	 * Create toolbars
	 */
	_defineToolbars_: function() {
		this._getBuilder_()
		.beginToolbar("tlbTimerList", {dc: "timer"})
			.addTitle().addSeparator().addSeparator()
			.addQuery().addNew().addCopy().addDeleteSelected()
			.addReports()
		.end()
		.beginToolbar("tlbTimerEdit", {dc: "timer"})
			.addTitle().addSeparator().addSeparator()
			.addSave().addNew().addCopy().addCancel()
			.addReports()
		.end();
	}

	
	,_when_called_to_view_: function(params) {
		
		var timer = this._getDc_("timer");
		if (timer.isDirty()) {
			this._alert_dirty_();
			return;
		}
		timer.doClearQuery();	 
		
		timer.setFilterValue("id", params.id );
		timer.setFilterValue("name", params.name );
		timer.setFilterValue("jobContextId", params.jobContextId );
		timer.setFilterValue("jobContext", params.jobContext );
		timer.doQuery();
	}
});

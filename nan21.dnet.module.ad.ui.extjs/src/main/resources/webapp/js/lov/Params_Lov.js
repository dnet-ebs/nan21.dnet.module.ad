/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "Params_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_Params_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:350, maxHeight:200
	},
	_editDialog_: {
		name: "MyParam_Ui",
		bundle: Dnet.bundle.ad
	},
	recordModel: Dnet.ns.ad + "ParamLov_Ds"
});

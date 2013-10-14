/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "Users_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_Users_Lov",
	displayField: "code",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{code}, {name}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "User_Ui",
		bundle: Dnet.bundle.ad
	},
	recordModel: Dnet.ns.ad + "UserLov_Ds"
});

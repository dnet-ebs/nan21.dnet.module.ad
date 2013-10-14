/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "Menus_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_Menus_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}, {title}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "Menu_Ui",
		bundle: Dnet.bundle.ad
	},
	recordModel: Dnet.ns.ad + "MenuLov_Ds"
});

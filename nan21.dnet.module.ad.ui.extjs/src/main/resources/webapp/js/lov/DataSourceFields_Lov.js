/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
Ext.define(Dnet.ns.ad + "DataSourceFields_Lov" , {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.ad_DataSourceFields_Lov",
	displayField: "name",
	listConfig: {
		getInnerTpl: function() {
			return '<span>{name}, {description}</span>';
		},
		width:250, maxHeight:350
	},
	_editDialog_: {
		name: "DataSource_Ui",
		bundle: Dnet.bundle.ad
	},
	recordModel: Dnet.ns.ad + "DataSourceFieldLov_Ds"
});

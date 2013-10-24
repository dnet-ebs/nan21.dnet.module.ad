/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

public class ViewStateRtLov_DsParam {

	public static final String f_hideMine = "hideMine";
	public static final String f_hideOthers = "hideOthers";

	private Boolean hideMine;

	private Boolean hideOthers;

	public Boolean getHideMine() {
		return this.hideMine;
	}

	public void setHideMine(Boolean hideMine) {
		this.hideMine = hideMine;
	}

	public Boolean getHideOthers() {
		return this.hideOthers;
	}

	public void setHideOthers(Boolean hideOthers) {
		this.hideOthers = hideOthers;
	}
}

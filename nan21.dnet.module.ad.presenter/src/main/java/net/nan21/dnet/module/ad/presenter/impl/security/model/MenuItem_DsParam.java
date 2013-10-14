/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

public class MenuItem_DsParam {

	public static final String f_foldersOnly = "foldersOnly";
	public static final String f_framesOnly = "framesOnly";

	private Boolean foldersOnly;

	private Boolean framesOnly;

	public Boolean getFoldersOnly() {
		return this.foldersOnly;
	}

	public void setFoldersOnly(Boolean foldersOnly) {
		this.foldersOnly = foldersOnly;
	}

	public Boolean getFramesOnly() {
		return this.framesOnly;
	}

	public void setFramesOnly(Boolean framesOnly) {
		this.framesOnly = framesOnly;
	}
}

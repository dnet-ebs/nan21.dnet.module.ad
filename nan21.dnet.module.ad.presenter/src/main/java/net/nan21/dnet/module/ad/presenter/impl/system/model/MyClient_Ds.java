/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

import net.nan21.dnet.core.api.annotation.Ds;
import net.nan21.dnet.core.api.annotation.DsField;
import net.nan21.dnet.core.api.annotation.SortField;
import net.nan21.dnet.core.presenter.model.AbstractTypeWithCodeNTDs;
import net.nan21.dnet.module.ad.domain.impl.system.Client;

@Ds(entity = Client.class, sort = {@SortField(field = MyClient_Ds.f_code)})
public class MyClient_Ds extends AbstractTypeWithCodeNTDs<Client> {

	public static final String f_workspacePath = "workspacePath";
	public static final String f_importPath = "importPath";
	public static final String f_exportPath = "exportPath";
	public static final String f_tempPath = "tempPath";
	public static final String f_adminRole = "adminRole";

	@DsField
	private String workspacePath;

	@DsField
	private String importPath;

	@DsField
	private String exportPath;

	@DsField
	private String tempPath;

	@DsField
	private String adminRole;

	public MyClient_Ds() {
		super();
	}

	public MyClient_Ds(Client e) {
		super(e);
	}

	public String getWorkspacePath() {
		return this.workspacePath;
	}

	public void setWorkspacePath(String workspacePath) {
		this.workspacePath = workspacePath;
	}

	public String getImportPath() {
		return this.importPath;
	}

	public void setImportPath(String importPath) {
		this.importPath = importPath;
	}

	public String getExportPath() {
		return this.exportPath;
	}

	public void setExportPath(String exportPath) {
		this.exportPath = exportPath;
	}

	public String getTempPath() {
		return this.tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getAdminRole() {
		return this.adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}
}

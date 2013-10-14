/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.domain.impl.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import net.nan21.dnet.core.domain.impl.AbstractTypeWithCodeNT;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Application client(tenant) definition. 
 */
@Entity
@Table(name = Client.TABLE_NAME)
public class Client extends AbstractTypeWithCodeNT {

	public static final String TABLE_NAME = "SYS_CLIENT";

	private static final long serialVersionUID = -8865917134914502125L;

	/**
	 * Specify which is the administrator role. Access rights are not checked
	 * for the users having this role granted so they have access to ALL of the
	 * functions.
	 */
	@Column(name = "ADMINROLE", length = 32)
	private String adminRole;

	/**
	 * Client workspace location. Valid absolute directory. If it does not exist
	 * it is created.
	 */
	@NotBlank
	@Column(name = "WORKSPACEPATH", nullable = false, length = 255)
	private String workspacePath;

	/**
	 * Import files path
	 */
	@NotBlank
	@Column(name = "IMPORTPATH", nullable = false, length = 255)
	private String importPath;

	/**
	 * Export files path
	 */
	@NotBlank
	@Column(name = "EXPORTPATH", nullable = false, length = 255)
	private String exportPath;

	/**
	 * Temporary files path
	 */
	@NotBlank
	@Column(name = "TEMPPATH", nullable = false, length = 255)
	private String tempPath;

	public String getAdminRole() {
		return this.adminRole;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
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

	@PrePersist
	public void prePersist() {
		super.prePersist();
	}
}

/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.system.model;

public class Client_DsParam {

	public static final String f_adminUserCode = "adminUserCode";
	public static final String f_adminUserName = "adminUserName";
	public static final String f_adminUserLogin = "adminUserLogin";
	public static final String f_adminPassword = "adminPassword";
	public static final String f_initFileLocation = "initFileLocation";

	private String adminUserCode;

	private String adminUserName;

	private String adminUserLogin;

	private String adminPassword;

	private String initFileLocation;

	public String getAdminUserCode() {
		return this.adminUserCode;
	}

	public void setAdminUserCode(String adminUserCode) {
		this.adminUserCode = adminUserCode;
	}

	public String getAdminUserName() {
		return this.adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminUserLogin() {
		return this.adminUserLogin;
	}

	public void setAdminUserLogin(String adminUserLogin) {
		this.adminUserLogin = adminUserLogin;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getInitFileLocation() {
		return this.initFileLocation;
	}

	public void setInitFileLocation(String initFileLocation) {
		this.initFileLocation = initFileLocation;
	}
}

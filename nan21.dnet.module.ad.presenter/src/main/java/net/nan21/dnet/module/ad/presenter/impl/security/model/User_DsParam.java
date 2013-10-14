/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.presenter.impl.security.model;

public class User_DsParam {

	public static final String f_newPassword = "newPassword";
	public static final String f_confirmPassword = "confirmPassword";
	public static final String f_withRoleId = "withRoleId";
	public static final String f_withRole = "withRole";
	public static final String f_inGroupId = "inGroupId";
	public static final String f_inGroup = "inGroup";

	private String newPassword;

	private String confirmPassword;

	private String withRoleId;

	private String withRole;

	private String inGroupId;

	private String inGroup;

	public String getNewPassword() {
		return this.newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return this.confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getWithRoleId() {
		return this.withRoleId;
	}

	public void setWithRoleId(String withRoleId) {
		this.withRoleId = withRoleId;
	}

	public String getWithRole() {
		return this.withRole;
	}

	public void setWithRole(String withRole) {
		this.withRole = withRole;
	}

	public String getInGroupId() {
		return this.inGroupId;
	}

	public void setInGroupId(String inGroupId) {
		this.inGroupId = inGroupId;
	}

	public String getInGroup() {
		return this.inGroup;
	}

	public void setInGroup(String inGroup) {
		this.inGroup = inGroup;
	}
}

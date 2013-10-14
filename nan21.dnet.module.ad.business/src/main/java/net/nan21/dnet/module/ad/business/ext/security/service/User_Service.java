/**
 * DNet eBusiness Suite
 * Copyright: 2010-2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */

package net.nan21.dnet.module.ad.business.ext.security.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.security.IPasswordValidator;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.module.ad.business.api.security.IUserService;
import net.nan21.dnet.module.ad.domain.impl.security.User;

/**
 * Business extensions specific for {@link User} domain entity.
 * 
 */
public class User_Service extends
		net.nan21.dnet.module.ad.business.impl.security.User_Service implements
		IUserService {

	@Override
	protected void preInsert(User e) throws BusinessException {
		if (e.getPassword() == null || "".equals(e.getPassword())) {
			e.setPassword(this.encryptPassword(e.getLoginName()));
		}
	}

	@Override
	public void doChangePassword(String userId, String newPassword)
			throws BusinessException {

		User u = this.findById(userId);
		if (!u.getClientId().equals(Session.user.get().getClientId())) {
			throw new BusinessException(
					"Acces to a different client is not allowed!");
		}
		try {
			this.getApplicationContext().getBean(IPasswordValidator.class)
					.validate(newPassword);
		} catch (Exception e) {
			throw new BusinessException("Pasword validation failed.", e);
		}
		u.setPassword(this.encryptPassword(newPassword));
		this.getEntityManager().merge(u);

	}

	private String encryptPassword(String password) throws BusinessException {
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new BusinessException(
					"Cannot change password. No `MD5` algorithm found.");
		}
		messageDigest.update(password.getBytes(), 0, password.length());
		String hashedPass = new BigInteger(1, messageDigest.digest())
				.toString(16);
		if (hashedPass.length() < 32) {
			hashedPass = "0" + hashedPass;
		}
		return hashedPass;
	}

}

/** 
 * DNet eBusiness Suite
 * Copyright: 2013 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms.
 */
package net.nan21.dnet.module.ad.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import net.nan21.dnet.core.api.security.IChangePasswordService;
import net.nan21.dnet.core.api.security.IPasswordValidator;
import net.nan21.dnet.module.ad.domain.impl.security.User;

public class ChangePasswordService extends AbstractSecurity implements
		IChangePasswordService {

	public void doChangePassword(String userCode, String newPassword,
			String oldPassword, String clientId, String clientCode)
			throws Exception {

		EntityManager em = this.getEntityManager();
		User u = null;

		if (newPassword != null && !"".equals(newPassword)
				&& newPassword.equals(oldPassword)) {
			throw new Exception("New password is the same as the old password.");
		}
		try {
			u = em.createQuery(
					"select e from "
							+ User.class.getSimpleName()
							+ " e where e.code = :code and e.clientId = :clientId",
					User.class).setParameter("code", userCode)
					.setParameter("clientId", clientId).getSingleResult();
		} catch (NoResultException e) {
			throw new Exception("Invalid user.");
		}

		String hashedOldPassword = this.encryptPassword(oldPassword);

		if (!u.getPassword().equals(hashedOldPassword)) {
			throw new Exception("Incorrect password.");
		}

		this.getApplicationContext().getBean(IPasswordValidator.class)
				.validate(newPassword);

		String hashedNewPassword = this.encryptPassword(newPassword);
		u.setPassword(hashedNewPassword);
		em.merge(u);

	}

	protected String encryptPassword(String thePassword)
			throws NoSuchAlgorithmException {

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(thePassword.getBytes(), 0, thePassword.length());
		String hashedPass = new BigInteger(1, messageDigest.digest())
				.toString(16);
		if (hashedPass.length() < 32) {
			hashedPass = "0" + hashedPass;
		}
		return hashedPass;
	}

}

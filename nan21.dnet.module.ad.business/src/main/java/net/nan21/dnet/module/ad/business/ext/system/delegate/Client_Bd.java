package net.nan21.dnet.module.ad.business.ext.system.delegate;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.nan21.dnet.core.api.Constants;
import net.nan21.dnet.core.api.action.impex.IImportDataPackage;
import net.nan21.dnet.core.api.exceptions.BusinessException;
import net.nan21.dnet.core.api.security.DnetClient;
import net.nan21.dnet.core.api.security.DnetUser;
import net.nan21.dnet.core.api.security.DnetWorkspace;
import net.nan21.dnet.core.api.security.IClient;
import net.nan21.dnet.core.api.security.IUser;
import net.nan21.dnet.core.api.security.IWorkspace;
import net.nan21.dnet.core.api.service.business.IImportDataPackageService;
import net.nan21.dnet.core.api.session.Session;
import net.nan21.dnet.core.business.service.AbstractBusinessDelegate;
import net.nan21.dnet.module.ad.domain.impl.security.Role;
import net.nan21.dnet.module.ad.domain.impl.security.User;
import net.nan21.dnet.module.ad.domain.impl.system.Client;

public class Client_Bd extends AbstractBusinessDelegate {

	final static Logger logger = LoggerFactory.getLogger(Client_Bd.class);

	/**
	 * Create a new client with an administrator user and initial data import
	 * from the specified location.
	 * 
	 * Executed in a system-user context
	 * 
	 * @param client
	 * @param userCode
	 * @param userName
	 * @param loginName
	 * @param password
	 * @param importJob
	 * @param importPath
	 * @throws BusinessException
	 */
	public void createClientWithAdminUserAndSetup(Client client,
			String userCode, String userName, String loginName,
			String password, IImportDataPackage dataPackage) throws BusinessException {

		this.setupNewClient(client, userCode, userName, loginName, password,
				dataPackage);

	}

	/**
	 * Create a new client with an administrator user.
	 * 
	 * Executed in a system-user context
	 * 
	 * @param client
	 * @param userCode
	 * @param userName
	 * @param password
	 * @throws BusinessException
	 */
	public void createClientWithAdminUser(Client client, String userCode,
			String userName, String loginName, String password)
			throws BusinessException {
		this.setupNewClient(client, userCode, userName, loginName, password,
				null);
	}

	/**
	 * Private worker method.
	 * 
	 * Client is created in the current system-user context, then the initial
	 * data-import is executed in the context of the newly created administrator
	 * user of the new client.
	 * 
	 * @param client
	 * @param userCode
	 * @param userName
	 * @param password
	 * @param importJob
	 * @throws BusinessException
	 */
	private void setupNewClient(Client client, String userCode,
			String userName, String loginName, String password,
			IImportDataPackage dataPackage) throws BusinessException {

		client.setAdminRole(Constants.ROLE_ADMIN_CODE);
		client.setActive(true);
		this.getEntityManager().persist(client);

		IUser su = Session.user.get();
		IClient c = new DnetClient(client.getId(), client.getCode(),
				client.getName());
		IWorkspace ws = new DnetWorkspace(client.getWorkspacePath());
		IUser newUser = new DnetUser(su.getCode(), su.getName(),
				su.getLoginName(), "", null, null, c, su.getSettings(),
				su.getProfile(), ws, false);

		try {
			Session.user.set(newUser);

			Role radmin = new Role();
			radmin.setCode(Constants.ROLE_ADMIN_CODE);
			radmin.setName(Constants.ROLE_ADMIN_NAME);
			radmin.setDescription(Constants.ROLE_ADMIN_DESC);
			radmin.setActive(true);
			this.getEntityManager().persist(radmin);

			Role ruser = new Role();
			ruser.setCode(Constants.ROLE_USER_CODE);
			ruser.setName(Constants.ROLE_USER_NAME);
			ruser.setDescription(Constants.ROLE_USER_DESC);
			ruser.setActive(true);
			this.getEntityManager().persist(ruser);

			Collection<Role> roles = new ArrayList<Role>();
			roles.add(radmin);
			roles.add(ruser);

			User u = new User();

			u.setCode(userCode);
			u.setName(userName);
			u.setLoginName(loginName);

			u.setActive(true);
			MessageDigest messageDigest;

			try {
				messageDigest = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				throw new BusinessException(
						"No MD5 algrorithm available to encode user password.");
			}
			messageDigest.update(password.getBytes(), 0, password.length());
			String hashedPass = new BigInteger(1, messageDigest.digest())
					.toString(16);
			if (hashedPass.length() < 32) {
				hashedPass = "0" + hashedPass;
			}

			u.setPassword(hashedPass);
			u.setRoles(roles);
			this.getEntityManager().persist(u);

			if (dataPackage != null) {
				this.getApplicationContext()
						.getBean(IImportDataPackageService.class)
						.doExecute(dataPackage);
			}
		} catch (Exception e) {
			throw new BusinessException(e.getMessage(), e);
		} finally {
			Session.user.set(su);
		}
	}
}

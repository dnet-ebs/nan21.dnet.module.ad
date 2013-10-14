package net.nan21.dnet.module.ad.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.nan21.dnet.core.api.exceptions.InvalidConfiguration;
import net.nan21.dnet.core.api.security.DnetClient;
import net.nan21.dnet.core.api.security.DnetSessionUser;
import net.nan21.dnet.core.api.security.DnetUser;
import net.nan21.dnet.core.api.security.DnetUserProfile;
import net.nan21.dnet.core.api.security.DnetUserSettings;
import net.nan21.dnet.core.api.security.DnetWorkspace;
import net.nan21.dnet.core.api.security.IAuthenticationClientUserService;
import net.nan21.dnet.core.api.security.ISessionUser;
import net.nan21.dnet.core.api.security.IUser;
import net.nan21.dnet.core.api.security.IUserProfile;
import net.nan21.dnet.core.api.security.IWorkspace;
import net.nan21.dnet.core.api.security.LoginParams;
import net.nan21.dnet.core.api.security.LoginParamsHolder;
import net.nan21.dnet.module.ad.domain.impl.security.Role;
import net.nan21.dnet.module.ad.domain.impl.security.User;
import net.nan21.dnet.module.ad.domain.impl.system.Client;
import net.nan21.dnet.module.ad.domain.impl.system.DateFormatMask;

/**
 * 
 * Authenticates login credentials against users defined in DNet-AD module.
 * 
 * @author amathe
 * 
 */
public class AuthenticationClientUserService extends AbstractSecurity implements
		IAuthenticationClientUserService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		EntityManager em = this.getEntityManager();

		LoginParams lp = LoginParamsHolder.params.get();
		Client c = null;
		User u = null;
		try {
			c = em.createQuery(
					"select e from " + Client.class.getSimpleName()
							+ " e where e.code = :code", Client.class)
					.setParameter("code", lp.getClientCode()).getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("Invalid credentials");
		}

		if (!c.getActive()) {
			throw new UsernameNotFoundException("Inactive client");
		}

		try {
			u = em.createQuery(
					"select e from "
							+ User.class.getSimpleName()
							+ " e where e.loginName = :loginName and e.clientId = :clientId",
					User.class).setParameter("loginName", username)
					.setParameter("clientId", c.getId()).getSingleResult();
		} catch (NoResultException e) {
			throw new UsernameNotFoundException("Invalid credentials");
		}

		ISessionUser su;
		try {
			su = buildSessionUser(c, u, lp);
		} catch (InvalidConfiguration e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
		return su;
	}

	public ISessionUser buildSessionUser(Client c, User u, LoginParams lp)
			throws InvalidConfiguration {

		boolean isAdmin = false;
		List<String> roles = new ArrayList<String>();

		for (Role role : u.getRoles()) {
			roles.add(role.getCode());
			if (role.getCode().equals(c.getAdminRole())) {
				isAdmin = true;
			}
		}

		DnetClient client = new DnetClient(c.getId(), c.getCode(), c.getName());
		IWorkspace ws = new DnetWorkspace(c.getWorkspacePath(),
				c.getImportPath(), c.getExportPath(), c.getTempPath());

		DnetUserSettings settings = DnetUserSettings.newInstance(this
				.getSettings());

		if (u.getThousandSeparator() != null && u.getDateFormat() != null) {
			String numberFormat = "0" + u.getThousandSeparator() + "000"
					+ u.getDecimalSeparator() + "00";
			settings.setNumberFormat(numberFormat);
		}

		if (u.getDateFormat() != null) {
			for (DateFormatMask mask : u.getDateFormat().getMasks()) {
				settings.setDateFormat(mask.getMask(), mask.getValue());
			}
		}

		IUserProfile profile = new DnetUserProfile(isAdmin, roles, false,
				false, u.getLocked());
		IUser user = new DnetUser(u.getCode(), u.getName(), u.getLoginName(),
				u.getPassword(), null, null, client, settings, profile, ws,
				false);
		ISessionUser su = new DnetSessionUser(user, lp.getUserAgent(),
				new Date(), lp.getRemoteHost(), lp.getRemoteIp());
		return su;
	}
}

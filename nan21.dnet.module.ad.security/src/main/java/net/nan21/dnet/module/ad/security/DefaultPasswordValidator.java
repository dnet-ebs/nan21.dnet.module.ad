package net.nan21.dnet.module.ad.security;

import net.nan21.dnet.core.api.security.IPasswordValidator;

/**
 * Simple password validator. Extend it according to your needs or use a a third
 * party password validator.
 * 
 * @author amathe
 * 
 */
public class DefaultPasswordValidator implements IPasswordValidator {

	@Override
	public void validate(String passwordToValidate) throws Exception {
		if (passwordToValidate == null || passwordToValidate.equals("")) {
			throw new Exception("Empty password not allowed");
		}
		if (passwordToValidate.length() < 4) {
			throw new Exception("Password must be at least 4 characters long.");
		}

	}

}

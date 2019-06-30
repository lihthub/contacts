package com.example.contacts.manager.security;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * MD5密码校验
 *
 * @author 李海涛 2016年9月2日
 */
public class Md5PasswordService implements PasswordService {
	private static final String MD5_SALT = "e87cf83d8d9d9d3c2e4r5t7y8g9";

	/**
	 * 加密密码
	 */
	@Override
	public String encryptPassword(Object plaintextPassword)
			throws IllegalArgumentException {
		Md5Hash encryptPassword = new Md5Hash(new Md5Hash(
				String.valueOf(plaintextPassword), MD5_SALT).toBase64(),
				MD5_SALT);
		return encryptPassword.toString();
	}

	/**
	 * 匹配密码
	 */
	@Override
	public boolean passwordsMatch(Object submittedPlaintext, String encrypted) {
		return encryptPassword(String.valueOf((char[]) submittedPlaintext)).equals(encrypted);
	}

}

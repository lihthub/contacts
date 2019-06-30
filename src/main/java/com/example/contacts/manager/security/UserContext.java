package pers.contacts.core.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import pers.contacts.entity.User;

/**
 * 用户上下文
 * 
 * @author Hollis
 */
public final class UserContext {
	
	/**
	 * 获取当前用户信息
	 * 
	 * @return
	 */
	public static User getCurUser() {
		try {
			Subject subject = SecurityUtils.getSubject();
			User user = (User) subject.getPrincipal();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 登录注销
	 * 
	 * @return
	 */
	public static boolean logout() {
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}

package com.example.contacts.manager.security;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.example.contacts.entity.User;
import com.example.contacts.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm {
	@Resource
	private UserService userService;

	/**
	 * 为当前登录的Subject授予角色和权限 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//		User shiroUser = (User) principals.getPrimaryPrincipal();
//		List<String> userRoles = userService.findUserRolesByUserId(shiroUser.getId());
//		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		authorizationInfo.addRoles(userRoles);
//		return authorizationInfo;
		return null;
	}

	/**
	 * 验证当前登录Subject的身份信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken uptoken = (UsernamePasswordToken) token;
		User user = userService.findByPhone(uptoken.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		}
		return null;
	}
	
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        super.setCredentialsMatcher(credentialsMatcher);
    }

}

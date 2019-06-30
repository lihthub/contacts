package com.example.contacts.manager.security;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;


public class MyFormAuthenticationFilter extends FormAuthenticationFilter {
	public static final String ERROR_KEY_ATTRIBUTE_NAME = "loginFailure";

	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		
		request.setAttribute(DEFAULT_USERNAME_PARAM, (String) token.getPrincipal());
		if (e instanceof IncorrectCredentialsException) { // 密码错误
			request.setAttribute(ERROR_KEY_ATTRIBUTE_NAME, "incorrectCredentials");
		} else if (e instanceof UnknownAccountException) { // 账号不存在
			request.setAttribute(ERROR_KEY_ATTRIBUTE_NAME, "unknownAccount");
		} else if (e instanceof LockedAccountException) { // 账号被锁定
			request.setAttribute(ERROR_KEY_ATTRIBUTE_NAME, "lockedAccount");
		} else {
			request.setAttribute(ERROR_KEY_ATTRIBUTE_NAME, "unknown");
		}
		return super.onLoginFailure(token, e, request, response);
	}
	
}

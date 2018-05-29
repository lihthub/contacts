<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<link rel="stylesheet" href="${ctx}/assets/css/pages/login.css" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="signin">
			<div class="signin-heading">
				<img src="${ctx}/assets/images/signin-logo.png">
				<h2><spring:message code="text.signintitle"/></h2>
			</div>
			<div class="signin-body">
				<div class="signin-form-top signin-form-error ${requestScope.loginFailure != null ? 'error' : ''}"><!-- error -->
					<spring:message code="error.usernameorpassword"/>
					<span class="close">&times;</span>
				</div>
				<form action="${ctx}/login" class="signin-form" method="post">
					<div class="form-group">
						<label for="inputUsername"><spring:message code="label.phone"/></label>
						<input type="tel" id="inputUsername" name="username" value="${requestScope.username}" autofocus="autofocus" placeholder="<spring:message code="input.placeholder.phone"/>" data-title="<spring:message code="input.title.phone"/>" pattern="1(3|4|5|8)[0-9]{9}" required="required"/>
					</div>
					<div class="form-group">
						<span><label for="inputPassword"><spring:message code="label.password"/></label><a class="pull-right" href="#"><spring:message code="a.forgotpassword"/></a></span>
						<input type="password" id="inputPassword" name="password" placeholder="<spring:message code="input.placeholder.password"/>" data-title="<spring:message code="input.title.password"/>" pattern="^\w{6,18}$" required="required"/>
					</div>
					<div class="form-group">
						<input type="submit" value="<spring:message code="button.signin"/>" />
					</div>
				</form>
				<div class="signin-form-bottom text-center">
					<spring:message code="text.newtocontacts"/> <a href="${ctx}/register"><spring:message code="a.createanaccount"/></a>
				</div>
			</div>
			<div class="signin-footer">
				<a href="?locale=zh_CN">中文</a>&nbsp;<a href="?locale=en_US">English</a>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctx}/assets/js/pages/login.js"></script>
</body>
</html>
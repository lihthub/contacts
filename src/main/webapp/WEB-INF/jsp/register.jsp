<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<link rel="stylesheet" href="${ctx}/assets/css/pages/register.css" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="signup">
			<div class="signup-heading">
				<img src="${ctx}/assets/images/signin-logo.png">
				<h2><spring:message code="text.signuptitle"/></h2>
			</div>
			<div class="signup-body">
				<div class="signup-form-top signup-form-error"><!-- error -->
					<spring:message code="error.usernameorpassword"/>
					<span class="close">&times;</span>
				</div>
				<form action="${ctx}/users/save" class="signup-form" method="post">
					<div class="form-group">
						<label for="inputName"><spring:message code="label.name"/></label>
						<input type="text" id="inputName" name="name" autofocus="autofocus" placeholder="<spring:message code="input.placeholder.name"/>" data-title="input.title.name" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputPassword"><spring:message code="label.password"/></label>
						<input type="password" id="inputPassword" name="password" placeholder="<spring:message code="input.placeholder.password"/>" data-title="<spring:message code="input.title.password"/>" pattern="^\w{6,18}$" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputPassword2"><spring:message code="label.password2"/></label>
						<input type="password" id="inputPassword2" name="password2" placeholder="<spring:message code="input.placeholder.password2"/>" data-title="<spring:message code="input.title.password2"/>" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputPhone"><spring:message code="label.phone"/></label>
						<input type="tel" id="inputPhone" name="phone" autofocus="autofocus" placeholder="<spring:message code="input.placeholder.phone"/>" data-title="<spring:message code="input.title.phone"/>" pattern="1(3|4|5|8)[0-9]{9}" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputEmail"><spring:message code="label.email"/></label>
						<input type="email" id="inputEmail" name="email" placeholder="<spring:message code="input.placeholder.email"/>" data-title="<spring:message code="input.title.email"/>" required="required"/>
					</div>
					<div class="form-group">
						<label for="selectSex"><spring:message code="label.sex"/></label>
						<select id="selectSex" name="sex">
							<option value="<spring:message code="option.sex.male"/>"><spring:message code="option.sex.male"/></option>
							<option value="<spring:message code="option.sex.female"/>"><spring:message code="option.sex.female"/></option>
						</select>
					</div>
					<div class="form-group">
						<label for="inputBirthday"><spring:message code="label.birthday"/></label>
						<input type="date" id="inputBirthday" name="birthday"  placeholder="<spring:message code="input.placeholder.birthday"/>" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputCompany"><spring:message code="label.company"/></label>
						<input type="text" id="inputCompany" name="company" placeholder="<spring:message code="input.placeholder.company"/>" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputJob"><spring:message code="label.job"/></label>
						<input type="text" id="inputJob" name="job" placeholder="<spring:message code="input.placeholder.job"/>" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputAddress"><spring:message code="label.address"/></label>
						<input type="text" id="inputAddress" name="address" placeholder="<spring:message code="input.placeholder.company"/>" required="required"/>
					</div>
					<div class="form-group">
						<label for="inputIntroduce"><spring:message code="label.introduce"/></label>
						<textarea id="inputIntroduce" name="introduce" rows="4" placeholder="<spring:message code="input.placeholder.introduce"/>"></textarea>
					</div>
					<div class="form-group">
						<input type="submit" value="<spring:message code="button.signup"/>"/>
					</div>
				</form>
				<div class="signup-form-bottom text-center">
					<spring:message code="a.hadanaccount"/> <a href="${ctx}/login"><spring:message code="a.signin"/></a>
				</div>
			</div>
			<div class="signup-footer">
				<a href="?locale=zh_CN">中文</a>&nbsp;<a href="?locale=en_US">English</a>
			</div>
		</div>
	</div>
</body>
</html>
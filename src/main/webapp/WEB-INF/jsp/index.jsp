<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<link rel="stylesheet" href="${ctx}/assets/css/pages/index.css" type="text/css" />
<link rel="stylesheet" href="${ctx}/assets/plugins/font-awesome/css/font-awesome.min.css" type="text/css" />
<script type="text/javascript" src="${ctx}/assets/js/pages/index.js"></script>
</head>
<body>
	<div class="container">
		<div class="main">
			<div class="top"><span id="systime"></span></div>
			<div class="left">
				<hr/><i class="fa fa-qrcode" aria-hidden="true" data-title="二维码"></i>
				<input type="hidden" id="linkman-id" value="${curUser.id}" data-role="user"/>
				<div class="photo-field">
					<div class="photo-circle">
						<img src="${ctx}/assets/images/signin-logo.png"/>
					</div>
				</div>
				<div class="field">
					<i class="fa fa-user"></i>
					<span id="nameSpan">${curUser.name}</span>
				</div>
				<div class="field">
					<i class="fa fa-male"></i>
					<span id="sexSpan">${curUser.sex}</span>
				</div>
				<div class="field">
					<i class="fa fa-phone"></i>
					<span id="phoneSpan">${curUser.phone}</span>
				</div>
				<div class="field">
					<i class="fa fa-envelope"></i>
					<span id="emailSpan">${curUser.email}</span>
				</div>
				<div class="field">
					<i class="fa fa-calendar"></i>
					<span id="birthdaySpan"><fmt:formatDate value="${curUser.birthday}" type="date"/></span>
				</div>
				<div class="field">
					<i class="fa fa-birthday-cake"></i>
					<span id="ageSpan">${curUser.getAge()}</span>岁
				</div>
				<div class="field">
					<i class="fa fa-bank"></i>
					<span id="companySpan">${curUser.company}</span>
				</div>
				<div class="field">
					<i class="fa fa-briefcase"></i>
					<span id="jobSpan">${curUser.job}</span>
				</div>
				<div class="field">
					<i class="fa fa-group"></i>
					<span id="relationSpan"></span>
				</div>
				<div class="field">
					<i class="fa fa-home"></i>
					<span id="addressSpan">${curUser.address}</span>
				</div>
			</div>
			<div class="right">
				<hr/><span class="signout" data-title="注销">&times;</span>
				<div class="userinfo">
					<div class="photo">
						<img src="${ctx}/assets/images/signin-logo.png"/>
					</div>
					<div class="information">
						<div class="name">${curUser.name}</div>
						<div class="other">${curUser.sex} ${curUser.getAge()}岁 ${curUser.address}</div>
						<div class="signature" data-title="个性签名">
							${curUser.introduce}
						</div>
					</div>
				</div>
				<div class="linkmen-box">
					<div class="search"><img src="${ctx}/assets/images/search.png"><input type="search" id="keyword" placeholder="搜索联系人" name="search"/></div>
					<div class="linkmen">
						<!-- 联系人列表 -->
					</div>
					<div class="addlinkman"></div>
				</div>
				<div class="letters">
					<ul>
						<li>#</li>
						<li>A</li>
						<li>B</li>
						<li>C</li>
						<li>D</li>
						<li>E</li>
						<li>F</li>
						<li>G</li>
						<li>H</li>
						<li>I</li>
						<li>J</li>
						<li>K</li>
						<li>L</li>
						<li>M</li>
						<li>N</li>
						<li>O</li>
						<li>P</li>
						<li>Q</li>
						<li>R</li>
						<li>S</li>
						<li>T</li>
						<li>U</li>
						<li>V</li>
						<li>W</li>
						<li>X</li>
						<li>Y</li>
						<li>Z</li>
					</ul>
				</div>
			</div>
			<div class="footer">&copy; <spring:message code="copyright"/></div>
		</div>
	</div>
	
	<!-- 遮罩层 -->
	<div class="window-mask"></div>
	
	<!-- 添加/修改联系人窗口 -->
	<div class="window">
		<div class="window-head">
			<span class="window-title">保存联系人</span>
			<span class="window-close">&times;</span>
		</div>
		<div class="window-content">
			<form class="linkman-form" method="post">
				<div class="form-head">
					<div class="photo choose-pic">
						<img src="${ctx}/assets/images/signin-logo.png"/>
						<input name="photo" type="file" accept="image/*"/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-user"></i>
						<input type="text" id="inputName" name="name" autofocus="autofocus" placeholder="输入姓名" data-title="请输入姓名" required="required"/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-male"></i>
						<div class="male"><input type="radio" name="sex" checked="checked" value="男">男</div>
						<div class="female"><input type="radio" name="sex" value="女">女</div>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-phone"></i>
						<input type="tel" id="inputPhone" name="phone" placeholder="输入手机号码" data-title="请输入正确格式的手机号码" pattern="1(3|4|5|8)[0-9]{9}" required="required"/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-envelope"></i>
						<input type="email" id="inputEmail" name="email" placeholder="输入邮箱" data-title="请输入正确格式的邮箱" required="required"/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-calendar"></i>
						<input type="date" id="inputBirthday" name="birthday" placeholder="选择生日" data-title="请选择生日" required="required"/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-bank"></i>
						<input type="text" id="inputCompany" name="company" placeholder="输入公司" data-title="请输入公司" required="required"/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-briefcase"></i>
						<input type="text" id="inputJob" name="job" placeholder="输入职位" data-title="请输入职位" required="required"/>
					</div>
				</div>
				<div class="form-row">
					<div class="input-group">
						<i class="fa fa-group"></i>
						<select id="selectRelation" data-title="请选择关系" required="required">
							<option></option>
							<option>家人</option>
							<option>朋友</option>
							<option>同事</option>
						</select>
					</div>
				</div>
				<div class="form-row address">
					<div class="input-group">
						<i class="fa fa-home"></i>
						<input type="text" id="inputAddress" name="address" placeholder="输入地址" data-title="请输入地址" required="required"/>
					</div>
				</div>
			</form>
		</div>
		<div class="window-buttons">
			<button class="window-ok">保存</button>
			<button class="window-cancel">取消</button>
		</div>
	</div>
	
	<div class="qrcode-win">
		<i class="fa fa-times-circle-o close" aria-hidden="true"></i>
		<img alt="QRCode" w src="${ctx}/users/${curUser.id}/qrcode">
	</div>
</body>
</html>
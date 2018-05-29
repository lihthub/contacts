<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>注册成功</title>
<style type="text/css">
	.success-box {
		margin: 200px auto;
		width: 260px;
		height: 100px;
		text-align: center;
	}
	
	.success-box .message {
		font-size: 18px;
	}
	
	.success-box .remark {
		font-size: 10px;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="success-box">
			<p class="message"><strong>✔</strong>&nbsp;注册成功</p>
			<p class="remark">登录名为手机号 <span id="after">10</span>秒后跳转到<a href="${ctx}/login">登录</a>页面</p>
		</div>
	</div>
	<script>
		setInterval(function() {
			var after = document.getElementById('after');
			var second = parseInt(after.innerHTML);
			if (second == 1) {
				location.href = webContext + "/login";
				return;
			}
			after.innerHTML = second - 1;
		}, 1000);
	</script>
</body>
</html>
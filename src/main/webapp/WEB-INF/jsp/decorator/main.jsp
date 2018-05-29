<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="languageTag" value="${requestScope.languageTag}" />
<!DOCTYPE html>
<html>
<head>
	<title><sitemesh:write property='title' /></title>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="description" content="">
	<link rel="shortcut icon" type="image/x-icon" href="${ctx}/favicon.ico">
	
	<link rel="stylesheet" href="${ctx}/assets/css/common.css" type="text/css" />
	
	<script type="text/javascript">
		var webContext = '${ctx}';
		var languageTag = '${languageTag}';
	</script>
	
	<script type="text/javascript" src="${ctx}/assets/js/lib/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/js/lib/jquery.i18n.properties.min.js"></script>
	<script type="text/javascript" src="${ctx}/assets/js/common.js"></script>
	<script type="text/javascript" src="${ctx}/assets/js/utils.js"></script>
	
	<sitemesh:write property='head' />
</head>
<body>
	<sitemesh:write property='body' />
</body>
</html>
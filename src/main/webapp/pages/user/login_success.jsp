<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录成功</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" style=" margin-right:60px;  height: 200px; width: 200px; border-radius: 50%" alt="" src="../../static/img/花店logo.jpg" >
				<%@ include file="/pages/common/welcom_common.jsp"%>
		</div>
		
		<div id="main">

			<c:if test="${sessionScope.user.jurisdiction == 0}">
				<h1>管理员${sessionScope.user.username}欢迎回来 <a style="color: #FCD1D1" href="/FlowerManageSystem/FlowerServlet?method=page">转到后台管理</a></h1>
			</c:if>
			<c:if test="${sessionScope.user.jurisdiction == 1}">
				<h1>用户${sessionScope.user.username}欢迎回来 <a style="color: #FCD1D1" href="/FlowerManageSystem/ClientServlet?method=page">转到主页</a></h1>
			</c:if>
		</div>

		<%@ include file="/pages/common/foot.jsp"%>

</body>
</html>
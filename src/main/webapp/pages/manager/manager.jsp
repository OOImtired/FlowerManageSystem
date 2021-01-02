<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
		<img class="logo_img" style=" margin-right:60px;  height: 200px; width: 200px; border-radius: 50%" alt="" src="../../static/img/花店logo.jpg" >
		<span class="wel_word" style="margin-top: 60px">后台管理系统</span>
		<%@ include file="/pages/common/manage_common.jsp"%>
	</div>
	
	<div id="main">
		<h1>欢迎管理员进入后台管理系统</h1>
	</div>

	<%@ include file="/pages/common/foot.jsp"%>

</body>
</html>
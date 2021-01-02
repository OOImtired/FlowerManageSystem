<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>
	<link type="text/css" rel="stylesheet" href="/FlowerManageSystem/static/css/style.css" >
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
			<span class="wel_word" style="margin-top: 60px">结算</span>
		<%@ include file="/pages/common/welcom_common.jsp"%>
	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为${sessionScope.orderId}</h1>
		
	
	</div>

	<%@ include file="/pages/common/foot.jsp"%>

</body>
</html>
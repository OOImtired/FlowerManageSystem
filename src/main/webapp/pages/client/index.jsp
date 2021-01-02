<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一间花店首页</title>
	<link type="text/css" rel="stylesheet" href="/FlowerManageSystem/static/css/style.css" >
	<link type="text/css" rel="stylesheet" href="/FlowerManageSystem/static/css/font-awesome.css">
	<script type="text/javascript" src="static/script/jquery-1.7.2.min.js"></script>

	<script type="text/javascript">
		$(function (){
			$("button.addToCart").click(function () {
				var flowerId = $(this).attr("flowerId");
				location.href = "http://localhost:8080/FlowerManageSystem/CartServlet?action=addItem&id=" + flowerId;
				/*$.getJSON("http://localhost:8080/FlowerManageSystem/CartServlet","action=ajaxAddItem&id="+flowerId,function (data){
					$("#cartTotalCount").text(+data.totalCount);
					$("#cartLastName").text(data.lastName);*/
				})
			})
	</script>

</head>
<body>
	
	<div id="header">
		<img class="logo_img" style=" margin-right:60px;  height: 200px; width: 200px; border-radius: 50%" alt="" src="/FlowerManageSystem/static/img/花店logo.jpg" >
			<span class="wel_word" style="font-size: 40px; margin-top: 70px">一间花店</span>
			<div style="margin-top: 90px">
				<c:if test="${empty sessionScope.user}">
					<a href="pages/cart/cart.jsp"><i class="fa fa-shopping-cart" style="font-size: 40px;color: #FCD1D1">&nbsp;</i></a>
					<a href="pages/user/login.jsp"><i class="fa fa-user" style="font-size: 40px;color: #FCD1D1">&nbsp;</i></a>
					<a href="pages/user/regist.jsp"><i class="fa fa-user-plus" style="font-size: 40px;color: #FCD1D1"></i></a>
				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<span>欢迎<span class="um_span" style="color: #FCD1D1">${sessionScope.user.username}</span>光临一间花店&nbsp;</span>
					<a href="pages/cart/cart.jsp"><i class="fa fa-shopping-cart" style="font-size: 40px;color: #FCD1D1">&nbsp;</i></a>
					<a href="/FlowerManageSystem/OrderServlet?action=queryOrder"><i class="fa fa-bars" style="font-size: 40px;color: #FCD1D1">&nbsp;</i></a>
					<a href="/FlowerManageSystem/UserLoginServlet?method=logout"><i class="fa fa-user-times" style="font-size: 40px;color: #FCD1D1"></i></a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${sessionScope.user.jurisdiction == 0}">
					<a href="pages/manager/manager.jsp"><i class="fa fa-user-secret" style="font-size: 40px;color: #FCD1D1"></i></a>
				</c:if>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="/FlowerManageSystem/ClientServlet" method="get">
					<input type="hidden" name="method" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
					<input id="max" type="text" name="max" value="${param.max}"> 元
					<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${empty sessionScope.cart.items}">
					<span id = "cartTotalCount">&nbsp;</span>
					<div>
						<span  style="color: #FCD1D1">您的购物车中没有商品</span>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.cart.items}">

					<span>您的购物车中有<span  style="color: #FCD1D1">${sessionScope.cart.totalCount}</span>件商品</span>
					<div>
						您刚刚将<span id="cartLastName" style="color: #FCD1D1">${sessionScope.lastName}</span>加入到了购物车中
					</div>
				</c:if>

			</div>

			<c:forEach items="${requestScope.page.items}" var="flower">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${flower.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">花名:</span>
							<span class="sp2">${flower.flowerName}</span>
						</div>
						<div class="book_author">
							<span class="sp1">价格:</span>
							<span class="sp2">${flower.flowerPrice}</span>
						</div>
						<div class="book_price">
							<span class="sp1">热度:</span>
							<span class="sp2">${flower.flowerHot}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">简介:</span>
							<span class="sp2">${flower.flowerIntroduction}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">销量:</span>
							<span class="sp2">${flower.flowerSales}</span>
						</div>
						<div class="book_add">
							<button FlowerId="${flower.id}" class="addToCart">加入购物车</button>
						</div>
					</div>
				</div>
			</c:forEach>

			<%@include file="/pages/common/page_common.jsp"%>
	
	</div>
	</div>
	<%@ include file="/pages/common/foot.jsp"%>

</body>
</html>
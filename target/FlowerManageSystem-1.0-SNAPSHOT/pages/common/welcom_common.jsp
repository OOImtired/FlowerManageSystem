<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: OOI‘m tired
  Date: 2020/12/27
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="/FlowerManageSystem/static/css/font-awesome.css">

<div>
    <c:if test="${not empty sessionScope.user}">
        <span>欢迎<span style="color: #FCD1D1" class="um_span">${sessionScope.user.username}</span>光临一间花店</span>
        <a href="/FlowerManageSystem/OrderServlet?action=queryOrder"><i class="fa fa-bars" style="font-size: 40px;color: #FCD1D1">&nbsp;</i></a>
        <a href="/FlowerManageSystem/UserLoginServlet?method=logout"><i class="fa fa-user-times" style="font-size: 40px;color: #FCD1D1"></i></a>&nbsp;&nbsp;
    </c:if>
    <c:if test="${empty sessionScope.user}">
        <span>尚未注册或登录，请前往注册登录</span>
        <a href="../../pages/user/login.jsp"><i class="fa fa-user" style="font-size: 40px;color: #FCD1D1">&nbsp;</i></a>
        <a href="../../pages/user/regist.jsp"><i class="fa fa-user-plus" style="font-size: 40px;color: #FCD1D1"></i></a>
    </c:if>

    <a href="/FlowerManageSystem/ClientServlet?method=page"><i class="fa fa-arrow-left" style="font-size: 40px;color: #FCD1D1"></i></a>
</div>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一间花店登录页面</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
<form action="/FlowerManageSystem/UserLoginServlet" method="post">

		<div id="login_header">
			<img class="logo_img" style=" margin-right:60px;  height: 85px; width: 85px; border-radius: 50%" alt="" src="../../static/img/花店logo.jpg" >
		</div>
		
			<div class="login_banner" style="background-color: #FCD1D1">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>一间花店</h1>
								<a href="regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg">请输入用户名和密码</span>
							</div>
							<div class="form">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
							</div>
						</div>
					</div>
				</div>
			</div>
	<%@ include file="/pages/common/foot.jsp"%>

</form>
</body>
</html>
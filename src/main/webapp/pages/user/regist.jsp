<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一间花店注册页面</title>
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
	<script type="text/javascript" src="../../static/script/jquery-1.7.2.min.js"></script>

	<script type="text/javascript">
		$(function (){
			$("#username").blur(function (){
				//获取用户名
				var username = this.value;
				//发起AJAX请求
				$.getJSON("http://localhost:8080/FlowerManageSystem/UserRegistServlet","action=ajaxExistsUsername&username="+username,function (data){
					if(data.existUsername){
						$("span.errorMsg").text("用户名已存在！");
					}else{
						$("span.errorMsg").text("用户名可用！");
					}
				});
			});
		})
	</script>

	<%--<script>

		function validate() {

			var email=document.getElementById("email").value;
			var password=document.getElementById("password").value;

			//验证邮箱合法性
			var pattern=/^([a-zA-z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;

			if(email==''){
				alert("email不能为空！");
				return false;
			}else if(!pattern.test(email)){
				alert("email格式不正确！");
				return false;
			}

			//验证password
			if(password==''){
				alert("password不能为空！");
				return false;
			}else if(password.length<6||password.length>12){
				alert("密码长度在6-12个字符之间！");
				return false;
			}
			return true;
		}
	</script>
--%>
	<style type="text/css">
	.login_form{
		height:480px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
<form action="/FlowerManageSystem/UserRegistServlet?action=register" method="post">
		<div id="login_header">
			<img class="logo_img" style=" margin-right:60px;  height: 85px; width: 85px; border-radius: 50%" alt="" src="../../static/img/花店logo.jpg" >
		</div>
		
			<div class="login_banner" style="background-color: #FCD1D1">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="email" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>注册身份：</label>
									<select name="jurisdiction" required style="width: 233px; height: 40px">
										<option class="itxt" value="0">管理员</option>
										<option class="itxt" value="1">用户</option>
									</select>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" id="code" name="code"/>
									<img id="code_img" alt=""  src="../../kaptcha.jpg" style="width: 80px;float: right;margin-right: 50px;height: 40px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
							</div>
							
						</div>
					</div>
				</div>
			</div>
	<%@ include file="/pages/common/foot.jsp"%>
<script>
	$("#code_img").click(function (){
		$("#code_img").attr("src","../../kaptcha.jpg?d=" + new Date())
	});
</script>
</form>
</body>
</html>
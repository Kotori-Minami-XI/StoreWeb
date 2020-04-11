<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>码蚁商城后台管理系统</title>
		<link href="../favicon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="css/style.css" type="text/css" />

	</head>

	<body>
		<div id="container">
			
			<form action="${pageContext.request.contextPath}/AdminLoginServlet">
				<div class="login">后台管理系统
				 <!--  <span style="color:red">用户名密码错</span> -->
				</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="username" value="myxq" />
				</div>
				<div class="password-field">
					<input type="password" name="password" value="1234" />
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住我</label>
	
				<div class="forgot-usr-pwd">忘记密码</div>
				<input type="submit" name="submit" value="GO" />
			</form>
		</div>

	</body>
</html>

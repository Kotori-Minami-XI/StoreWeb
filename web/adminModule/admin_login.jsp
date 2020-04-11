<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>后台管理系统</title>
		<link href="${pageContext.request.contextPath}/adminModule/favicon.ico" rel="shortcut icon">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/adminModule/css/style.css" type="text/css" />
	</head>


	<body>
		<div id="container">
			
			<form action="${pageContext.request.contextPath}/AdminLoginServlet" method="post">
				<div class="login">后台管理系统</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="username" value="${lastUsername}" />
				</div>
				<div class="password-field">
					<input type="password" name="password" value="" />
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住我</label>
	
				<div class="forgot-usr-pwd">
					<a href="#">忘记密码?</a>
					<span style="color:red">${error}</span>
                </div>
				<input type="submit" name="submit" value="登录" />
			</form>
		</div>

	</body>
</html>

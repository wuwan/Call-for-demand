<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
<!--
 .red {
	color: #ff0000;
}
</style>
<title>登录失败</title>
</head>
<body>
	<div align="center" style="margin-top:30px;font-size:22px;">
		<span><a><i class="red">登录失败！</i></a></span>
	</div>
	<div align="center" style="margin-top:30px;font-size:22px;">
		<span><a>用户名或密码错误！3秒后返回登录界面。</a></span>
	<script type="text/javascript">
		setTimeout(reDo,3000);
		function reDo(){
			window.location.href="login.jsp";
		}
	</script>
	</div>
</body>
</html>
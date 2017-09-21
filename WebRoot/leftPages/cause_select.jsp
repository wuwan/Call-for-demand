<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@ page import="java.sql.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>退回理由</title>
</head>
<style type="text/css">
<!--
 .STYLE1 {
	font-family: "楷体";
	font-size: 18px;
	color: #666666;
	font-weight: bold;
}
 .STYLE2 {
	font-family: "楷体";
	font-size: 16px;
	color: #000000;
}
-->
</style>
<body>
	<form action="cause_update.jsp" method="post">
		<table class="STYLE2" align="center" style="margin-top:20px;margin-bottom:50px">
			<tr>
				<td colspan="3">需求编号：</td>
				<td colspan="2">${reject.crorder}</td>
			</tr>
			<tr>
			<td colspan="3">退回理由：</td>
			<td colspan="5">${reject.cause}</td>			
			</tr>
			</table>
	</form>
</body>
</html>

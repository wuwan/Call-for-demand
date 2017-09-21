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
	<form action="tuihui1.action" method="post">
	 <input type="hidden" name="param" value="1"/>
		<table class="STYLE2" align="center" style="margin-top:20px;margin-bottom:50px">
			<tr>
				<td colspan="3">需求编号：</td>
				<td colspan="5">${tbgovbelong.cborder}</td>
			</tr>
			<tr>
								<td width="20"><input name="reject.crorder" value="${tbgovbelong.cborder}" type="hidden">
							</tr>
			<tr>
			<td colspan="3">退回理由：</td>
			<td colspan="5"><textarea name="reject.cause" id="cause" rows="7" cols="70" ></textarea></td>			
			</tr>
			<tr>
								<td width="20"><input name="reject.re1" value="已通过" type="hidden" id="Role">
							</tr>
			<tr>
								<td width="20"><input name="reject.re2" value="已退回" type="hidden" id="Role">
							</tr>
			<tr>
								<td width="20"><input name="reject.RAccount" value="${tbgovbelong.cbid}" type="hidden" id="Role">
							</tr>
			</table>
			<center>
			<input type="reset" value="重置" >
				<input type="submit" name="submit" value="保存">
				</center>
	</form>
</body>
</html>

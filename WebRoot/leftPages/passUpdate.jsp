<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改密码</title>
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
	<form action="userEdit.action" method="post">
	<input type="hidden" name="param" value="1"/>
	<div style="width: 100%; font-family: 华文行楷;font-size:30px; text-align: center">修改密码</div>
		<table class="STYLE2" align="center" style="margin-top:20px;margin-bottom:50px">
			<tr>
				<th width="30%">原　密　码　：</th>
				<td width="70%"><input name="password" type="password" id ="password" placeholder="输入原密码"></td>
			</tr>
			<tr>
				<th width="30%">修改　　密码：</th>
				<td width="70%"><input name="user.password" type="password"
                    id="Password" placeholder="6-20个字母数字"></td>
						
			</tr>
			<tr>
				<th width="30%">确认修改密码：</th>
				<td width="70%"><input name="pass1" type="password"
                    id="pass1" placeholder="6-20个字母数字"></td>
						
			</tr>
			<tr>
								<td width="20"><input name="user.number" value="${user.number}" type="hidden" id="Role">
							</tr>
			<tr>
								<td width="20"><input name="user.name" value="${user.name}" type="hidden" id="Role">
							</tr>
			<tr>
								<td width="20"><input name="user.address" value="${user.address}" type="hidden" id="Role">
							</tr>
			<tr>
								<td width="20"><input name="user.poster" value="${user.poster}" type="hidden" id="Role">
							</tr>
			<tr>
								<td width="20"><input name="user.role" value="${user.role}" type="hidden" id="Role">
							</tr>
			<tr>
				<th colspan="2"><input type="hidden" name="user.account" style="margin-right: 40px" value="${user.account}">
				<br>
					<input type="reset"
					value="重置">　　　　<input type="submit" value="修改" style="margin-right: 40px"> </th>
					
			</tr>
		</table>
	</form>
</body>
</html>








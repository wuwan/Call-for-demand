<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTf-8">
<title>添加用户和权限</title>
<style type="text/css">
span{color:red;}
</style>

<script type="text/javascript">
function check1() {    // 验证用户名
	 var value = trim(document.getElementById("Account").value);// 获取usernameObj中的文本
	 if (value.length==0)  {   // 如果用户名没填, 填了就是一个字符串可以当作true, 没填的话不论null或者""都是false	
	    document.getElementById("usernameMsg").innerText="用户名必须填写";
	 }
	 else{
		 document.getElementById("usernameMsg").innerText="";
	 }
	
}
function check2(){
	var a = document.getElementById("Password").value;
	if(a.length<6||a.length>20){
	    document.getElementById("pwd1").innerText="请输入6-20个可含字母数字";
	}
	else{
		document.getElementById("pwd1").innerText="";
	}
	}  
function check3(){
	var a = document.getElementById("Password").value;
	var b = document.getElementById("pass1").value;
	if(a!=b){
	    document.getElementById("pwd2").innerText="两次密码不一致";
	}
	else{
		document.getElementById("pwd2").innerText="";
	}
}  
function check4(){
	var a = document.getElementById("Poster").value;
	if(a.length!=6){
	    document.getElementById("pt").innerText="格式错误";
	}
	else{
		document.getElementById("pt").innerText="";
	}
}  
function check5(){
	var a = document.getElementById("Number").value;
	if(a.length!=18){
	    document.getElementById("nu").innerText="共18位";
	}
	else{
		document.getElementById("nu").innerText="";
	}
} 
function check6(){
	var a = document.getElementById("Name").value;
	if(a.length==0){
	    document.getElementById("na").innerText="输入机构名称";
	}
	else{
		document.getElementById("na").innerText="";
	}
}
function check7(){
	var a = document.getElementById("Address").value;
	if(a.length==0){
	    document.getElementById("ad").innerText="输入通讯地址";
	}
	else{
		document.getElementById("ad").innerText="";
	}
}

function star()
{
	if (form1.Account.value == "") {
		window.alert("请输入账号！");		
		form1.zzbm.focus();
		return false;
	}
	if (form1.Number.value == "") {
		window.alert("请输入公司编号！");
		form1.Number.focus();
		return false;
	}
	
	 if (form1.Name.value == "") {
			window.alert("请输入用户名！");
			form1.Name.focus();
			return false;
		}
		if (form1.Address.value == "") {
			window.alert("请输入公司名称！");
			form1.Address.focus();
			return false;
		}
		if (form1.Password.value == "") {
			window.alert("请输入密码！");
			form1.Password.focus();
			return false;
		}
		if (form1.pass1.value == "") {
			window.alert("请输入确认密码！");
			form1.pass1.focus();
			return false;
		}
        if(form1.pass.value!=form1.pass1.value){
	   alert("两次密码输入不正确！");return false;}
     return true;
}
</script>
</head>
<body>
<div align="center">
<center>
   <table width="800" border="0" align="center" cellpadding="0" cellspacing="0" >
   <tr>
      <td >  <br><br><br>
       <form name="form1" action="addUser.action" method="post"
						onSubmit="return star()">
						<table width="500" height="20" border="0" align="center"
							cellpadding="0" cellspacing="0">
							<tr align="center">
								<td width="50" height="50"><strong>用 户 名:</strong></td>
								<td width="20">
								<input type="hidden" name="param" value="1"/>
								<input name="user.account" value="${user.account}" type="text" size="20"
									id="Account" placeholder="作为系统用户使用" onchange="check1();">
									<span id="usernameMsg" style="display: inline;"></span></td>
							</tr>
							<tr align="center">
								<td width="50" height="50"><strong>身份证号:</strong></td>
								<td width="20"><input name="user.number" value="${user.number}" type="text"
									 id="Number" onchange="check5();">
									<span id="nu" style="display: inline;"></span></td>
							</tr>
							<tr align="center">
								<td width="50" height="50"><strong>机构名称:</strong></td>
								<td width="20"><input name="user.name" value="${user.name}" type="text"
									size="20" id="Name" onchange="check5();">
									<span id="nu" style="display: inline;"></span></td>
							</tr>
							<tr align="center">
								<td width="50" height="50"><strong>通讯地址:</strong></td>
								<td width="20"><input name="user.address" value="${user.address}" type="text" size="20"
									id="Address" onchange="check5();">
									<span id="nu" style="display: inline;"></span></td>
							</tr>
							<tr align="center">
								<td width="50" height="50"><strong>邮政编码:</strong></td>
								<td width="20"><input name="user.poster" value="${user.poster}" type="text" size="20"
									id="Poster" onchange="check4();">
									<span id="pt" style="display: inline;"></span></td>
							</tr>
							<tr align="center">
								<td width="50" height="50"><strong>密　　码:</strong></td>
								<td width="20"><input name="user.password" value="${user.password}" type="password"
									size="20" id="Password" onchange="check2();">
									<span id="pwd1" style="display: inline;"></span></td>
							</tr>
							<tr align="center">
							<td width="50" height="50"><strong>角　　色:</strong></td>
							<td width="20">
								<select name="user.role" id="user.role">  
				                <option>普通用户</option>
				                <option>形式审核人员</option>
				                <option>技术审核人员</option>
				                </select></td>
							</tr>
							<tr align="center">
								<td width="50" height="50"><strong>确认密码:</strong></td>
								<td width="20"><input name="pass1" type="password"
									size="20" id="pass1" onchange="check3();">
									<span id="pwd2" style="display: inline;"></span></td>
							</tr>
						</table>
						<p align="center">
						<input type="reset" name="Submit1" style="margin-left:0px" value="重置">&nbsp;&nbsp;　　
							<input  type="submit" name="submit" value="注册">
						</p>
					</form>
					<form name="form2" action="login.jsp" method="get">
    <p align="center">
    <input type="submit" name="Submit3"  value="返回"><font size="5xp"></font>&nbsp;&nbsp;</p>
    </form>
    </td>
   </table>
   </center>
   </div>
</body>
</html>
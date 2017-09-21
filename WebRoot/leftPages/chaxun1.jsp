<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@ page import="java.sql.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'chaxun1.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="jiaoben1286-fenye/css/slimtable.css">
<link rel="stylesheet" href="jiaoben1286-fenye/css/site.css">
<script type="text/javascript">
$(document).ready(function(){
		$(".div2").click(function(){ 
			$(this).next("div").slideToggle("slow")  
			.siblings(".div3:visible").slideUp("slow");
		});
	});
</script>
<style>
.STYLE1 {color: #fff}
a:link {
	text-decoration: none;
}
a:visited {
	text-decoration: none;
}
a:hover {
	text-decoration: none;
	color: #03F;
}
a:active {
	text-decoration: none;
	font-weight: bold;
	color: #03F;
}

body{ margin:0;}

.left{ width:200px; height:100%; border-right:1px solid #CCCCCC ;#FFFFFF; 

color:#000000; font-size:14px; text-align:center;}
.right{ width:200px; height:100%; border-right:1px solid #CCCCCC ;#FFFFFF; 

color:#000000; font-size:14px; text-align:right;}
.div1{text-align:center; width:200px; padding-top:10px;}
.div2{height:40px; line-height:40px;cursor: pointer; font-size:13px; 

position:relative;border-bottom:#ccc 1px dotted;}
.jbsz {position: absolute; height: 20px; width: 20px; left: 40px; top: 10px; 

1px dotted; text-align:center;}
</style>

	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <br>
  <br>
  <br>
  <br>
<script type="text/javascript" src="jiaoben1286-fenye/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="jiaoben1286-fenye/js/slimtable.min.js"></script>   
<center>	
	<table id="exampletable">
	<thead>
		<tr>
		    <th>填报机构</th>
			<th>组织编码</th>
			<th>需求编号</th>
			<th>形式审核状态</th>
			<th>操作</th>
		</tr>
	</thead>
		
		<s:iterator value="#request.demands" id="demand">
			  <tr>
			    <td width="100px"><s:property value="#demand.cbAccount"/></td>
			    <td width="100px"><s:property value="#demand.cbid"/></td>
				<td width="100px"><s:property value="#demand.cborder"/></td>
				<td width="100px"><s:property value="#demand.state"/>
				</td>
				<td width="50px">
					<a href="selectFormat.action?param=0&cborder=<s:property value="#demand.cborder"/>">查看</a>				
				</td></tr>
			</s:iterator>
	</table>
	</center>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
  </body>
</html>

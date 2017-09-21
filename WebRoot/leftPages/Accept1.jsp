<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>需求管理</title>
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

</head>
<body background="images/index.jpg">
    <br>
 	<br>
<script type="text/javascript" src="jiaoben1286-fenye/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="jiaoben1286-fenye/js/slimtable.min.js"></script>
	<form action="query1.action" method="post">
		<table align="center">
			<tr>
				<td style="vertical-align: middle;">需求编号：
					<input type="text" style="width: 300px;height: 30px;font-size: 16px" name="queryText"  value="${searchText }"/>
					<input type="submit" value="查询" style="width: 100px;height: 30px;font-size: 16px"/>
				</td>
			</tr>
		</table>
	</form>
<center>
	<table id="exampletable">
	<thead>
		<tr>
		    <th>填报机构</th>
			<th>填报人员身份证号</th>
			<th>需求编号</th>
			<th>形式审核状态</th>
			<th>技术审核状态</th>
			<th>操作</th>
		</tr>
	</thead>
		
		<c:forEach var="list" items="${tbgovbelongs }">
			<tr align="center"  height="24px">
				<td width="100">${list.cbAccount}</td>
				<td width="100">${list.cbid}</td>
				<td width="100">${list.cborder}</td>
				<td width="100">${list.state}</td>
				<td width="100">${list.state1}</td>
				<td width="120">
					<a href="needEdit.action?param=0&cborder=${list.cborder}">查看</a>&nbsp;&nbsp;
					<a href="needDelete.action?param=0&cborder=${list.cborder}">删除</a>&nbsp;&nbsp;
				</td>
			</tr>
		</c:forEach>
	</table>
	</center>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
</body>
</html>

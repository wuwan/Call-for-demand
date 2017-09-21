<%@ page language="java" contentType="text/html; charset=utf-8" import="com.ssh.orm.*,org.hibernate.Criteria,org.hibernate.Session,org.hibernate.criterion.Restrictions,java.util.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看我的需求</title>
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
<style type="text/css">
	td
	{
		text-align: center;
	}
	body{ margin:0;}

.left{ width:200px; height:100%; border-right:1px solid #CCCCCC ;#FFFFFF; 

color:#000000; font-size:14px; text-align:center;}
.right{ width:200px; height:100%; border-right:1px solid #CCCCCC ;#FFFFFF; 

color:#000000; font-size:14px; text-align:right;}
.div1{text-align:center; width:200px; padding-top:10px;}
.div2{height:40px; line-height:40px;cursor: pointer; font-size:13px; 

position:relative;border-bottom:#ccc 1px dotted;}
.jbsz {position: absolute; height: 20px; width: 20px; left: 40px; top: 40px; 

1px dotted; text-align:center;}
</style>
</head>
<body>
<script type="text/javascript" src="jiaoben1286-fenye/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="jiaoben1286-fenye/js/slimtable.min.js"></script>   
	<center>
		<table id="exampletable" width="1200px" border="1" cellspacing="0">
		<thead>
			<tr>
				<th>需求编号</th><th>填报机构</th><th>需求名称</th><th>所属地域</th><th>归口部门</th><th>操作</th>  
			</tr>
		</thead>
			<%
				//为什么提示重复
				
				
				List requirementList = (List)request.getAttribute("requirementList");
				int i=0;
				if(requirementList == null)
				{
					System.out.println("null");
				}
				else
				{
					Iterator it = requirementList.iterator();
					while(it.hasNext())
					{
						TbNeed require = new TbNeed();
						require = (TbNeed)(it.next());
						i++;
			 %>
			 <tr>
			 	<td><%=require.getCNumber() %> </td>
			 	<td><%=require.getName() %></td>
				<td><%=require.getCNeedName() %> </td>
				<td><%=require.getCMoneyElse() %> </td>
				<td><%=require.getCBelong() %> </td>
				<td><a href="<%=request.getContextPath() %>/selectFormat.action?param=0&cborder=<%=require.getCNumber() %>">查看</a></td>
			 </tr>
			 <%
			 		}%>
			  
		</table>
		<div style="position:absolute;left:150px">
		<table>
			 	<tr>
			 	<th width="70px">查询数量</th>
			    <th width="20px"><%=i%></th>
			 </tr>
			 </table>
			 </div>
			 <%
			 	}
			  %>
	</center>
<script type="text/javascript">
$(function() {
	$("#exampletable").slimtable();
});
</script>
</body>
</html>
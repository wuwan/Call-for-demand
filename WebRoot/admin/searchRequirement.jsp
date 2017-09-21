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

<title>需求管理</title>
    <link rel="stylesheet" type="text/css" href="http://piccache.cnki.net/kdn/kns/css/gb_min/ResultComp.min.css?v=" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/gb.ResultPage.min.js?v=D59787997F3B8FCE" ></script>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
<style type="text/css">
	a{ text-decoration:none}
	/*一级行业的样式*/
	.mins{}
	.plus{}
	/*二级行业的样式*/
	.mins2{}
	.plus2{}
	td
	{
		valign:top;
	}
	a{ font-size:15px;}
</style> 
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery-2.1.4/jquery.min.js"></script>
<script type='text/javascript'>
	function clickT(id)
		{
			var ele = document.getElementById("w");
			if(ele.checked)
			{
				alert();
			}
		}
	
</script>

<script type="text/javascript" language="javascript">   
function iFrameHeight() {   
var ifm= document.getElementById("res");   
var subWeb = document.frames ? document.frames["res"].document : ifm.contentDocument;   
if(ifm != null && subWeb != null) {
   ifm.height = subWeb.body.scrollHeight;
   ifm.width = subWeb.body.scrollWidth;
}   
}   
</script>
</head>

<body>
	<a id="searchLink" target="res"></a>
	<table border="2" >
		<tr>
			<td valign="top" width="200px">
				<div id="retrieveTree">
				检索目录结构
				</div>
			</td>
			<td valign="top" width="1100px">
				<iframe id="res" name="res" width="1100px">
				</iframe>
			</td>
		</tr>
	</table>
</body>

<script type="text/javascript">
  		$(
			function()
			{
				onReady();
			}
		);
		//记录检索条件行数的
  		var rowIndex = 3;
		
		//点击三级行业的复选框的时候要判断一级和二级复选框是否被选中   如果一级或二级复选框被选中的话  要取消一级或二级复选框的选中状态
		function threeIndustryBoxClick(code)
		{
			//获取当前行业的选择状态
			//获取这个三级行业复选框
			var threeIndustryBox = document.getElementById(code+"box");
			//复选框被选中
			if(threeIndustryBox.checked)
			{	
				//获取二级行业的复选款
				
				var twoIndustryBox = document.getElementById(code.substr(0,3)+"box");
				if(twoIndustryBox.checked)
				{
					twoIndustryBox.checked = false;
				}
				//获取一级行业的复选框
				var oneIndustryBox = document.getElementById(code.substr(0,1)+"box");
				if(oneIndustryBox.checked)
				{
					oneIndustryBox.checked = false;
				}
			}
		}
		
		//点击二级行业的复选框判断一级行业复选框是否被选中  如果一级行业的复选框被选中    则要取消一级行业的被选中状态
		//点击二级行业的复选框还要判断三级行业复选框是否被选中  如果三级行业复选框被选中的话   则要取消三级行业的被选中状态
		function twoIndustryBoxClick(code)
		{
			
			//获取二级行业
			var twoIndustryBox = document.getElementById(code+"box");
			if(twoIndustryBox.checked)
			{
				//获取一级行业
				var oneIndustryBox = document.getElementById(code.substr(0,1)+"box");
				//判断一级行业是否被选中
				if(oneIndustryBox.checked)
				{
					oneIndustryBox.checked = false;
				}
				//把该二级行业下面的三级行业全部设置为未选中
					var inputs = document.getElementsByTagName("input");//获取所有的input标签对象
					for(var i=0;i<inputs.length;i++)
					{
  						var obj = inputs[i];
  						if(obj.type=='checkbox')
  						{
  							var objId = obj.getAttribute("id");
  							//排除自己
     						if((objId != code) && (objId.substr(0,3) == code.substr(0,3)))
     						{
     							//id长度为5则一定是三级行业
     							if(objId.length == 8)
     							{
     								//找到该二级行业的三级行业
     								if(objId.substr(0,3) == code)
     								{
     									if(obj.checked)
     									{
     										obj.checked = false;
     									}
     								}
     							}
     							
     						}
  						}
					}	
				}
			}
		
		//点击一级行业的复选框判断二级行业和三级行业的复选框是否被选中  如果一级行业的复选框被选中    则要取消二级行业和三级行业的被选中状态
		function oneIndustryBoxClick(code)
		{
			
			//获取二级行业
			var oneIndustryBox = document.getElementById(code+"box");
			if(oneIndustryBox.checked)
			{
				
				//把该一级行业下面的二级行业全部设置为未选中
				var inputs = document.getElementsByTagName("input");//获取所有的input标签对象
				for(var i=0;i<inputs.length;i++)
					{
  						var obj = inputs[i];
  						if(obj.type=='checkbox')
  						{
  							var objId = obj.getAttribute("id");
     						if((objId != code+"box") && (objId.substr(0,1) == code.substr(0,1)))
     						{
     							if(obj.checked)
     							{
     								obj.checked = false;
     							}
     						}
  						}
					}			
				}
			}
		
		
		//点击减号要执行的事件
		function minsClick(code)
		{
			$("#"+code+"m").hide();
			$("#"+code+"m").prev().show();
			//遍历检索树，删掉相应的结点
			$("#"+code+"ul").children().each(function(i){
				//每一个ul下面的第一个是 +   第二个是-  第三个是选择框   第四个是行业名称   以后的才是子菜单
				if(i > 3)
				{
					$(this).remove();
				}
			});
		}
		
		//点击二级行业的加载三级行业
		function plusClick1(code,id)
			{
				var nowElement = $("#"+code+"p");
				nowElement.hide();
				nowElement.next().show();
				//使用ajax向后台发送数据
				$.ajax({
				//这里传递参数的时候不能写成这样 "SubjecttypeAction.action?action=twoIndustry&oneIndustry='"+code+"'"  为什么    不知道
				url:"SubjecttypeAction.action?action=threeIndustry&twoIndustry="+code,
				type:"post",
				dataType:"text",
				success:function(returnData)
				{
					//先用;把各个三级行业分开  
					var threeIndustry = returnData.split(";");
					//得到的是一个数组
					for(var i = 0;i < threeIndustry.length-1;i++)
					{
						//使用,来把行业的代码 名称   分开
						var tem3 = threeIndustry[i].split(",");
						var code3 = tem3[0];
						var title3 = tem3[1];
						nowElement.parent().append("<ul id='"+code3+"ul'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='hidden' id='"+code3+"box' onclick='threeIndustryBoxClick(\""+code3+"\");'/><a href='javascript:void(0);' id='"+code3+"' target='res' onclick='searchLinkClick(\""+code3+"\")'>"+title3+"</a></ul>");
					}	
					//$(".mins2").hide();   
				}});
			};
		//这个方法一定要写在调用他的方法之前   否则无法调用
		//点击一级菜单前面的加号加载二级行业
		function plusClick(code,id)
			{
				var nowElement = $("#"+code+"p");
				nowElement.hide();
				nowElement.next().show();
				//使用ajax向后台发送数据
				$.ajax({
				//这里传递参数的时候不能写成这样  "SubjecttypeAction.action?action=twoIndustry&oneIndustry='"+code+"'"  为什么    不知道
				url:"SubjecttypeAction.action?action=twoIndustry&oneIndustry="+code,
				type:"post",
				dataType:"text",
				success:function(returnData)
				{
					//先用;把各个一级行业分开  
					var twoIndustry = returnData.split(";");
					//得到的是一个数组
					for(var i = 0;i < twoIndustry.length-1;i++)
					{
						//使用,来把行业的代码 名称  以及是否有下一级学科  分开
						var tem2 = twoIndustry[i].split(",");
						var code2 = tem2[0];
						var title2 = tem2[1];
						var nextLevel2 = tem2[2];
						if(nextLevel2 == "true")
						{
							nowElement.parent().append("<ul id='"+code2+"ul'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0);' id='"+code2+"p' class='plus2' onclick='plusClick1(\""+code2+"\",\""+code2+"+\");'><img src='admin/image/file1.JPG' width='12' height='12'/></a><a href='javascript:void(0);' id='"+code2+"m' class='mins2' onclick='minsClick(\""+code2+"\");'><img src='admin/image/file2.JPG' width='12' height='12'/></a><input type='hidden' id='"+code2+"box' onclick='twoIndustryBoxClick(\""+code2+"\")'><a href='javascript:void(0);' id='"+code2+"' target='res' onclick='searchLinkClick(\""+code2+"\")'>"+title2+"</a></ul>");
						}
						else
						{
							nowElement.parent().append("<ul id='"+code2+"ul'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='hidden' id='"+code2+"box' onclick='twoIndustryBoxClick(\""+code2+"\")'><a href='javascript:void(0);' id='"+code2+"' target='res' onclick='searchLinkClick(\""+code2+"\")'>"+title2+"</a></ul>");
						}
					}	
					$(".mins2").hide();
				}});
			};	
			
			function searchLinkClick(code)
			{
				//alert(code);
				//保存检索条件的字符串
  				var searchCon = "";
  				//第一个查询条件没有逻辑变量，所以要特殊处理
  				/* searchCon += $("#conditionName1").val()+","+$("#conditionValue1").val()+","+$("#searchMethod1").val()+";";
  				for(var i = 2;i < rowIndex;i++)
  				{
  					searchCon += $("#bool"+i).val()+","+$("#conditionName"+i).val()+","+$("#conditionValue"+i).val()+","+$("#searchMethod"+i).val()+";";
  				} */
				//动态设置超链接的href
  				document.getElementById("searchLink").href="SubjecttypeAction.action?action=search&industry="+code+";&searchCon="+searchCon;
  				//alert("超链接已经设置");
  				//触发超链接的点击事件
  				document.getElementById("searchLink").click();
			} 
			/********************************************加载一级行业*****************************************************/
			function onReady(){
  			
  			//页面加载完成之后使用ajax加载后台传回来的所有的一级行业的字符串  onclick='plusClick(\""+code+"\",\""+code+"+\");'
  			$.ajax({
				url:"SubjecttypeAction.action?action=oneIndustry",
			type:"post",
			dataType:"text",
			success:function(returnData)
			{
				//异步提交请求时该属性失效
				//先用;把各个一级行业分开  
				var oneIndustry = returnData.split(";");
				//得到的是一个数组
				for(var i = 0;i < oneIndustry.length;i++)
				{
					//使用,来把行业的代码 名称  以及是否有下一级学科  分开
					var tem = oneIndustry[i].split(",");
					var code = tem[0];
					var title = tem[1];
					var nextLevel = tem[2];
					if(nextLevel == "true")
					{	
						var inde = code+"p";
						//这里调用plusClick()是传递参数必须用转义字符串
						$("#retrieveTree").append("<ul id='"+code+"ul'><a href='javascript:void(0);' name='000' id='"+inde+"' class='plus' onclick='plusClick(\""+code+"\",\""+code+"p\");'><img src='admin/image/file1.JPG' width='12' height='12'/></a><a href='javascript:void(0);' id='"+code+"m' class='mins' onclick='minsClick(\""+code+"\");'><img src='admin/image/file2.JPG' width='12' height='12'/></a><input type='hidden' id='"+code+"box' onclick='oneIndustryBoxClick(\""+code+"\")'><a id='"+code+"' target='res' onclick='searchLinkClick(\""+code+"\")'>"+title+"</a></ul>");
					}
					else
					{
						$("#retrieveTree").append("<ul id='"+code+"ul'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='hidden' id='"+code+"box' onclick='oneIndustryBoxClick(\""+code+"\")'><a href='javascript:void(0);' id='"+code+"' onclick='getTwoIndustry(code)'>"+title+"</a></ul>");
					}
					//$("#firSubName").append("<option value='firLevSubject[i]'>"+firLevSubject[i]+"</option>");
				}
				//加载完一级行业之后要让所有的-隐藏
			 	$(".mins").hide();
				//$(".plus").hide();
			}//ajax加载一级行业数据完成
			
			
			});
  			
  			//点击查询按钮要执行的事件
  			//为了能够使用<iframe>的效果   点击这个按钮的时候触发超链接的点击事件
  			$("#searchButton").click(function()
  			{
  				//保存国民经济行业的字符串
  				var industry = "";
  				//获取用户选择的国民经济行业
  				var inputs = document.getElementsByTagName("input");//获取所有的input标签对象
				for(var i=0;i<inputs.length;i++)
				{
  					var obj = inputs[i];
  					if(obj.type=='checkbox')
  					{
  						if(obj.checked)
     					{
     						var objId = obj.getAttribute("id");
     						industry += objId.substr(0,objId.indexOf("b"))+";";
     					}
  					}
				}
  				//保存检索条件的字符串
  				var searchCon = "";
  				//第一个查询条件没有逻辑变量，所以要特殊处理
  				searchCon += $("#conditionName1").val()+","+$("#conditionValue1").val()+","+$("#searchMethod1").val()+";";
  				for(var i = 2;i < rowIndex;i++)
  				{
  					searchCon += $("#bool"+i).val()+","+$("#conditionName"+i).val()+","+$("#conditionValue"+i).val()+","+$("#searchMethod"+i).val()+";";
  				}
  				//$("#searchLink").link = "http://www.baidu.com";
  				//动态设置超链接的href
  				document.getElementById("searchLink").href="SubjecttypeAction.action?action=search&industry="+industry+"&searchCon="+searchCon;
  				//触发超链接的点击事件
  				document.getElementById("searchLink").click();
			});
			
			
    		//动态设置iframe的大小
			function changeFrameHeight(code) {
				var ifm = document.getElementById("res");
				ifm.height = document.documentElement.clientHeight;
			}

			window.onresize = function() {
				changeFrameHeight();
			};

		//交替执行的事件
		$("#tt").click(function() {
			$("#t").toggle(function() {
				alert(1);
			}, function() {
				alert(0);
			});

		});

	};
</script>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<head>
<base href="<%=basePath%>">
    <title>需求征集信息</title>
<style type="text/css">
span{color:red;}
table {
	border-collapse: collapse;
	border: none;
	margin: 0px auto;
	width: 793px;
	font-family:SimHei;
}
th{
	border: solid #333 1px;
	font-size:20px;
}
td {
	border: solid #333 1px;
	font-size:20px;
}
input.full{width:100%; height:100%;}
option.afull{width:100%; height:100%;}
</style>

<script type="text/javascript">
////////////////////////////////////学科分类///////////////////////////////////////////////////
	if (window.ActiveXObject && !window.XMLHttpRequest) {
		window.XMLHttpRequest = function() {
			return new ActiveXObject((navigator.userAgent.toLowerCase()
					.indexOf('msie 6') != -1) ? 'Microsoft.XMLHTTP'
					: 'Msxml2.XMLHTTP');
		};
	}//取得XMLHttpRequest对象 
	var req;
	var flagSelect;
	function testName(flag, value)//使用Ajax访问服务器
	{
		flagSelect = flag; 
		req = new XMLHttpRequest();
		if (req) {
			req.onreadystatechange = setValue;
		}
		req.open('POST', "getinfo.jsp?flag=" + flag + "&value=" + value);//把参数带到服务器中
		req.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		req.send(null);
	}
	function setValue() {
		if (req.readyState == 4)//访问到服务器
		{
			if (req.status == 200)//正确返回
			{
				if (flagSelect == "1")
				{
					var v = req.responseText.split("||");//req.responseText是服务器返回来的字符串
					paint(document.all("sec"), v[0]);//
					paint(document.all("thi"), v[1]);//
				}
				if (flagSelect == "2")//
				{
					var v = req.responseText;//req.responseText是服务器返回来的字符串
					paint(document.all("thi"), v);//
				}
			}
		}
	}
	function paint(obj, value)//根据一对数据去更新一个下拉框
	{
		var ops = obj.options;
		var v = value.split(";");//得到一些数据,(修改过了..)
		while (ops.length > 0)//先清空原来的数据
		{
			ops.remove(0);
		}
		for (var i = 0; i < v.length - 1; i++)//把新得到的数据显示上去
		{
			var o = document.createElement("OPTION");//创建一个option把它加到下拉框中
			o.value = v[i].split(",")[0];
			o.text = v[i].split(",")[1];
			ops.add(o);
		}
	}
	
////////////////////////////////////行业分类///////////////////////////////////////////////////
	if (window.ActiveXObject&& !window.XMLHttpRequest) {
		window.XMLHttpRequest= function() {
			return new ActiveXObject((navigator.userAgent.toLowerCase()
					.indexOf('msie 6') != -1) ? 'Microsoft.XMLHTTP'
					: 'Msxml2.XMLHTTP');
		};
	}//取得XMLHttpRequest对象 
	var req;
	var flagSelect;
	function testName_A(flag, value)//使用Ajax访问服务器
	{
		flagSelect= flag; 
		req = new XMLHttpRequest();
		if (req) {
			req.onreadystatechange = setValue_;
		}
		req.open('POST', "getinfo_A.jsp?flag=" + flag + "&value=" + value);//把参数带到服务器中
		req.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');
		req.send(null);
	}
	function setValue_() {
		if (req.readyState == 4)//访问到服务器
		{
			if (req.status == 200)//正确返回
			{
				if (flagSelect == "1")
				{
					var v = req.responseText.split("||");//req.responseText是服务器返回来的字符串
					paint_(document.all("sec_A"), v[0]);//
					paint_(document.all("thi_A"), v[1]);//
				}
				if (flagSelect == "2")//
				{
					var v = req.responseText;//req.responseText是服务器返回来的字符串
					paint_(document.all("thi_A"), v);//
				}
			}
		}
	}
	function paint_(obj, value)//根据一对数据去更新一个下拉框
	{
		var ops = obj.options;
		var v = value.split(";");//得到一些数据,(修改过了..)
		while (ops.length > 0)//先清空原来的数据
		{
			ops.remove(0);
		}
		for (var i = 0; i < v.length - 1; i++)//把新得到的数据显示上去
		{
			var o = document.createElement("OPTION");//创建一个option把它加到下拉框中
			o.value = v[i].split(",")[0];
			o.text = v[i].split(",")[1];
			ops.add(o);
		}
	}
</script>
<!-- ---------------------------------------------------------------------- -->
<script type="text/javascript">

//关键词按顺序输入
function k(t){
	if(event.keyCode==9)t.style.display="";
}
</script>
<script type="text/javascript">
//限制字数不能超过500字，并且计算
function checktext(text) 
{ 
allValid = true; 
for (i = 0; i < text.length; i++) 
{ 
if (text.charAt(i) != " ") 
{ 
allValid = false; 
break; 
} 
} 
return allValid; 
} 

function gbcount(message,total,used,remain) 
{ 
var max; 
max = total.value; 
if (message.value.length > max) { 
message.value = message.value.substring(0,max); 
used.value = max; 
remain.value = 0; 
alert("不能超过 500 个字!"); 
} 
else { 
used.value = message.value.length; 
remain.value = max - used.value; 
} 
} 
</script>
<script type="text/javascript">
///////////////////验证不能为空
function check1() {
	
	if(form1.C_number.value=="")
		{
		alert("需求编号不能为空");
		document.form1.C_number.focus();
		return false}
}
</script>
<script type="text/javascript">
/////////////////////////////
function check2_1(){
	if(form1.C_introduce.value=="")
	{
	alert("机构简介不能为空");
	document.form1.C_introduce.focus();
	return false}
}
</script>
<script type="text/javascript">
///////////////////验证邮箱格式
function check2(){
	var reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;
	var a = document.getElementById("C_email").value;
    
	if(a=="")
    {
    	document.getElementById("em").innerText="邮箱不能为空";
    } 
    if(!reg.test(a))
    {
    	document.getElementById("em").innerText="邮箱格式不正确";
    } 
    else{
    	document.getElementById("em").innerText="";
    }
}
</script>
<script type="text/javascript">
/////////////////////////////
function check3(){
	if(form1.C_represent.value=="")
	{
	alert("法人代表不能为空");
	document.form1.C_represent.focus();
	return false}
}
function check4(){
	if(form1.C_connect.value=="")
	{
	alert("联系人不能为空");
	document.form1.C_connect.focus();
	return false}
}
</script>
<script type="text/javascript">
function check6(){
	if(form1.C_phone.value=="")
	{
	alert("手机号码不能为空");
	document.form1.C_phone.focus();
	return false}
}
function check9(){
	if(form1.C_Need_name.value=="")
	{
	alert("技术需求名称不能为空");
	document.form1.C_Need_name.focus();
	return false}
}
</script>
<script type="text/javascript">
function check11_1()
{
	alert("de");
	Date date1=new Date();
	SimpleDateFormat sdf1=new SimpleDateFormat("yyyy");
	String s1=sdf1.format(date1);

	var a=parseInt(document.form1.C_start.value);
	var c=parseInt(s1);
	if(a>c)
	{
	alert("开始年限不能大于当前年份");
	document.form1.C_end.focus();
    }
}
</script>
<script type="text/javascript">
function check11(){
	var a=parseInt(document.form1.C_start.value);
	var b=parseInt(document.form1.C_end.value);
	if(a>=b)
	{
	alert("开始年限不能大于截止年限");
	document.form1.C_end.focus();
	return false}
}
</script>
<script type="text/javascript">
/////////////////////////////////////////////////关键字//////////////////////
function check13(){
	var s=document.getElementById('C_key').value;
	if(s.length>10){
		alert("关键字不能超过十个");
		document.form1.C_key.focus();
		return false
	}
</script>
<script type="text/javascript">
function check17(){
	var s=document.getElementById('C_key1').value;
	if(s.length>10){
		alert("关键字不能超过十个");
		document.form1.C_key1.focus();
		return false
	}
}
</script>
<script type="text/javascript">
function check18(){
	var s=document.getElementById('C_key2').value;
	if(s.length>10){
		alert("关键字不能超过十个");
		document.form1.C_key2.focus();
		return false
	}
}
function check19(){
	var s=document.getElementById('C_key3').value;
	if(s.length>10){
		alert("关键字不能超过十个");
		document.form1.C_key3.focus();
		return false
	}
}
</script>
<script type="text/javascript">
function check20(){
	var s=document.getElementById('C_key4').value;
	if(s.length>10){
		alert("关键字不能超过十个");
		document.form1.C_key4.focus();
		return false
	}
}
///////////////////重大技术需求概述/////////////////////////////////////////////////
function check30(){
	var a = document.getElementById("C_important").value;
    System.out.println("ghjkl");
    if(a==null)
    {
    	document.getElementById("em1").innerText="主要问题不能为空";
    }
    else{
    	document.getElementById("em1").innerText="";
    }
}
</script>
<!-- ---------------------------------------------------------------------- -->
<script>
///////////////////////////////////基础研究，非基础研究////////////////////////////////////
function show(){
	var s=document.getElementsByName('C_research');
	for(var i=0;i<s.length;i++){
		if(s[i].checked==true&&s[i].value=="基础研究"){
			document.getElementById("e1").disabled=true;
			document.getElementById("e2").disabled=true;
			document.getElementById("e3").disabled=true;
			document.getElementById("e4").disabled=true;
			document.getElementById("e5").disabled=true;
			document.getElementById("e6").disabled=true;
			document.getElementById("e7").disabled=true;
			document.getElementById("e8").disabled=true;
			document.getElementById("e9").disabled=true;
			document.getElementById("e0").disabled=true;
			document.getElementById("fir_A").disabled=true;
			document.getElementById("sec_A").disabled=true;
			document.getElementById("thi_A").disabled=true;
		
			document.getElementById("fir").disabled=false;
			document.getElementById("sec").disabled=false;
			document.getElementById("thi").disabled=false;
		}
		if(s[i].checked==true&&s[i].value!="基础研究"){
			document.getElementById("e1").disabled=false;
			document.getElementById("e2").disabled=false;
			document.getElementById("e3").disabled=false;
			document.getElementById("e4").disabled=false;
			document.getElementById("e5").disabled=false;
			document.getElementById("e6").disabled=false;
			document.getElementById("e7").disabled=false;
			document.getElementById("e8").disabled=false;
			document.getElementById("e9").disabled=false;
			document.getElementById("e0").disabled=false;
			document.getElementById("fir_A").disabled=false;
			document.getElementById("sec_A").disabled=false;
			document.getElementById("thi_A").disabled=false;
			
			document.getElementById("fir").disabled=true;
			document.getElementById("sec").disabled=true;
			document.getElementById("thi").disabled=true;
		}
	}
}
</script>
<script type="text/javascript">
function star()
{
	if (form1.C_email.value == "") {
		window.alert("电子信箱不能为空！");
		form1.C_email.focus();
		return false;
	}
	if (form1.C_represent.value == "") {
		window.alert("法人代表不能为空！");
		form1.C_represent.focus();
		return false;
	}
	if (form1.C_connect.value == "") {
		window.alert("联系人不能为空！");
		form1.C_connect.focus();
		return false;
	}
	if (form1.C_phone.value == "") {
		window.alert("手机号码不能为空！");
		form1.C_phone.focus();
		return false;
	}
	if (form1.C_nature.value == "") {
		window.alert("机构属性不能为空！");		
		form1.C_nature.focus();
		return false;
	}
	if (form1.C_introduce.value == "") {
		window.alert("机构简介不能为空！");
		form1.C_introduce.focus();
		return false;
	}
		if (form1.C_important.value == "") {
			window.alert("主要问题不能为空！");
			form1.C_important.focus();
			return false;
		}
		if (form1.C_money_load.value == "") {
			window.alert("技术关键不能为空！");
			form1.C_money_load.focus();
			return false;
		}
		if (form1.C_money_total.value == "") {
			window.alert("预期目标不能为空！");
			form1.C_money_total.focus();
			return false;
		}
		if (form1.C_company.value == "") {
			window.alert("技术需求解决方式不能为空！");
			form1.C_company.focus();
			return false;
		}
		if (form1.C_research.value == "") {
			window.alert("科技活动类型不能为空！");
			form1.C_research.focus();
			return false;
		}
     return true;
}
</script>

</head>

<body background="images/index.jpg">

  <!-- ---------------------需求编号--------------------------- -->
  <%
   Date date=new Date();
   SimpleDateFormat  sdf=new SimpleDateFormat("yyyyMMdd");
   String CNumber=sdf.format(date);
  
   for(int i=0;i<4;i++){
	   int rand=(int)(Math.random()*9);
	   CNumber+=rand;
   }
    %>
   <!-- ---------------------------------------------------- -->  
<center>
    <h1 align="center">河北省重大技术需求征集表</h1>
<form action="needAdd.action"  method=post name="form1" onSubmit="return star()">
  <br>
      <input type="hidden" name="param" value="1"/>
	  <table width="793"  border="1" bgColor="#ffffff" align="center">
	  <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>需求编号</td>	    
				    <td colspan="6">
				    ${need.CNumber}</td>
	    </tr>
	    <!-- --------------------------------------------                 -->
	    <tr>
				    <td  width="10%"><span>*</span>机构全称</td>
				    <td width="40%" colspan="2">${need.name}</td>
				    <td  width="10%" colspan="2"><span>*</span>归口管理部门</td>
				    <td width="40%" colspan="2">${need.CBelong}</td>
				    </tr>
	    <!-- --------------------------------------------                 -->
				  <tr>
				    <td  width="10%"><span>*</span>通讯地址</td>
				    <td width="40%" colspan="2">${need.address}</td>
				    <td  width="10%" colspan="2"><span>*</span>所在地域</td>
				    <td width="40%" colspan="2">${need.CMoneyElse}</td>
	    </tr>
	    <!-- --------------------------------------------                 -->
				  <tr>
				    <td  width="10%">网　　址</td>
				    <td colspan="2" width="40%">${need.CWebsite}</td>
				    <td colspan="2" width="10%"><span>*</span>电子信箱</td>
				    <td colspan="2" width="40%" colspan="4">${need.CEmail}
				    <span id="em" style="display: inline;"></span></td>
	    </tr>
	    <!-- --------------------------------------------                 -->
				  <tr>
				    <td  width="10%"><span>*</span>法人代表</td>
				    <td colspan="2" width="40%">${need.CRepresent}</td>
				    <td colspan="2" width="10%">邮政编码</td>
				    <td colspan="2" width="40%">${need.poster}</td>
        </tr>
        <!-- --------------------------------------------                 -->
				  <tr>
				    <td width="10%"><span>*</span>　联系人</td>
				    <td colspan="2" width="40%">${need.CConnect}</td>
				    <td colspan="2" width="10%">固定电话</td>
				    <td colspan="2" width="40%">${need.CStand}</td>
        </tr>
        <!-- --------------------------------------------                 -->
				  <tr>
				  　<td width="10%"><span>*</span>手　　机</td>
				    <td colspan="2" width="40%">${need.CPhone}</td>
				    <td colspan="2" width="10%">传　　真</td>
				    <td colspan="2" width="40%">${need.CFax}</td>
        </tr>
        <!-- --------------------------------------------                 -->
				  <tr>
				    <td><span>*</span>机构属性</td>
				    <td colspan="6"><label><input type="radio" name="need.CNature" value="企业">企业</label>
				    <label><input name="need.CNature" type="radio" value="高等院校">高等院校 </label>
				    <label><input type="radio" name="need.CNature" value="研究机构">研究机构</label>
				    <label><input type="radio" name="need.CNature" value="其他">其他</label></td>
				    
	    </tr>
	    <!-- --------------------------------------------                 -->
				  
	    <!-- --------------------------------------------限500字以内             -->
				  <tr>
				    <td colspan="7" align="center"><span>*</span>机构简介（主要包括基本情况、现有研究基础等，限500字以内）</td>
				    
	    </tr>
				  <tr>
				    <td  colspan="7"><textarea name="need.CIntroduce" id="C_introduce"rows="10" wrap=PHYSICAL cols="130" readonly="readonly">${need.CIntroduce}</textarea></td>
	    </tr>
	    <tr><td>
	    输入情况
	    </td><td>最多字数： </td>
         <td>   <input disabled maxLength="4" name="total" size="13" value="500" class="inputtext"> </td>
                         <td>      已用字数：</td> 
           <td>  <input disabled maxLength="4" name="used" size="13" value="0" class="inputtext"> </td>
                                 <td>剩余字数：</td> 
             <td><input disabled maxLength="4" name="remain" size="13" value="500" class="inputtext"></td> 
              </tr>
	    <!-- --------------------------------------------                 -->
	    		  <tr>
				    <td><span>*</span>技术需求名称</td>
				    <td colspan="1">${need.CNeedName}</td>  
				    <td colspan="2">　　<span>*</span>需求时限</td>
				    <td>${need.CStart}</td>  
				    <td>年至</td>
				    <td>${need.CEnd}</td>              
	    </tr>
	    <!-- --------------------------------------------                 -->
	    <tr>
				    <td rowspan="6" colspan="1" align="center"><span>*</span>技术需求概述</td>
				    <td colspan="7" align="center">1、主要问题（需要解决的重大技术问题，限500字以内）</td>
				    
	    </tr>
				  <tr>
				    <td  colspan="7"><textarea name="need.CImportant" id="C_important" rows="10" cols="100" maxlength='500' readonly="readonly">${need.CImportant}</textarea><span id="em1" style="display: inline;"></span></td>
	    </tr>
	    <tr>
				    <td colspan="7" align="center">2、技术关键（所需的关键技术、主要指标，限500字以内）</td>
	    </tr>
	    <tr>
				    <td  colspan="7"><textarea name="need.CMoneyLoad" id="C_money_load" rows="10" cols="100"  maxlength='500' readonly="readonly">${need.CMoneyLoad}</textarea></td>
	    </tr>
	    <tr>
				    <td colspan="7" align="center">3、预期目标（技术创新性、经济社会效益，限500字以内）</td>
	    </tr>
	    <tr>
				    <td  colspan="7"><textarea name="need.CMoneyTotal" id="C_money_total" rows="10" cols="100"  maxlength='500' readonly="readonly">${need.CMoneyTotal}</textarea></td>
	    </tr>
	    <!-- --------------------------------------------                 -->
	    <tr>
				    <td colspan="2"><span>*</span>关键字</td>
				    <td >
				    ${need.CKey}</td>
				    <td >${need.CKey1}</td>
				    <td >${need.CKey2}</td>
				    <td >${need.CKey3}</td>
				    <td >${need.CKey4}
				    </td>                  
	    </tr>
	    <!-- --------------------------------------------                 -->
	    <!-- --------------------------------------------                 -->
	    <tr>
				    <td width="164" colspan="2">拟投入自有资金总额</td>
				    <td colspan="4">${need.CMoneySelf}</td>
        <td>万元</td>
        </tr>
        <!-- --------------------------------------------                 -->
        <tr>
				    <td rowspan="2"><span>*</span>技术需求解决方式</td>
				    <td colspan="6"><label><input type="radio" name="need.CCompany" id=" C_company" value="独立研发">独立研发</label>
				    <label><input name="need.CCompany" type="radio" id="C_company" value="委托研发">委托研发</label>
				    <label><input type="radio" name="need.CCompany" id="C_company" value="合作研发">合作研发</label>
				    <label><input type="radio" name="need.CCompany" id="C_company" value="其他">其他</label></td>
	    </tr>
	    <tr>
				    <td style="color:red">合作意向单位</td>
				    <td colspan="5">${need.CUnit}</td>                  
	    </tr>
	    <!-- --------------------------------------------                 -->
	    
	    <tr>
				    <td><span>*</span>科技活动类型</td>
				    <td colspan="6"><label><input type="radio" name="need.CResearch" id="C_research"value="基础研究" onchange="show()">基础研究</label>
				    <label><input name="need.CResearch" type="radio" id="C_research" value="应用研究" onchange="show()">应用研究 </label>
				    <label><input type="radio" name="need.CResearch" id="C_research" value="试验发展" onchange="show()">试验发展</label>
				    <label><input type="radio" name="need.CResearch" id="C_research" value="研究发展与成果应用" onchange="show()">研究发展与成果应用</label>
				    <label><input type="radio" name="need.CResearch" id="C_research" value="技术推广与科技服务" onchange="show()">技术推广与科技服务</label>
				    <label><input type="radio" name="need.CResearch" id="C_research" value="生产性活动" onchange="show()">生产性活动</label></td>
	    </tr>
	    <!-- ------------------------------------------------------------------->
	    <tr>
				    <td width="164">学科分类</td>
				    <td colspan="6">${need.CStudy}</td>
	    </tr>
	    <tr>
	    <!-- ------------------------------------------------------------------
	    <td>学科分类</td>
			<td>一级学科</td>
			<td><select name="fir" id="fir" onchange="testName(1,this.value);" >
			<option value=""></option>
					
			</select>
			</td>
			
			<td>二级学科</td>
			<td><select name="sec" id="sec" onchange="testName(2,this.value);">
			<option value=""></option>
					
			</select>
			</td>
			
			<td>三级学科</td>
			<td><select name="thi" id="thi">
			<option value=""></option>
					
			</select>
			</td>->	
		</tr>
	    <!-- --------------------------------------------                 -->
	    <tr>
				    <td>需求技术所属领域
（非基础研究填写）</td>
				    <td colspan="6"><label><input name="need.CNeedBelong" type="checkbox" id="e1" value="电子信息技术">电子信息技术</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e2" value="光机电一体化">光机电一体化</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e3" value="软件">软件</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e4" value="生物制药技术">生物制药技术</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e5" value="新材料及应用技术">新材料及应用技术</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e6" value="先进制造技术">先进制造技术</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e7" value="现代农业技术">现代农业技术</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e8" value="新能源与高效节能技术">新能源与高效节能技术</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e9" value="资源与环境保护新技术">资源与环境保护新技术</label>
				    <label><input name="need.CNeedBelong" type="checkbox" id="e0" value="其他技术（注明）">其他技术（注明）</label></td>
	    </tr>
	    <!------------------------------------------------------------------>
	     <tr>
				    <td width="164" colspan="3">需求技术应用行业</td>
				    <td colspan="4">${need.CApplication}</td>
	    </tr>
	    <!-------------------------------------------------------
	    <tr>
			<td rowspan="2" width="20%" height="50">需求技术应用行业</td>
			
			<td>一级行业</td>
			<td><select name="fir_A" id="fir_A" onchange="testName_A(1,this.value);" >
			<option value=""></option>
					
			</select>
			</td>
			
			<td>二级行业</td>
			<td><select name="sec_A" id="sec_A" onchange="testName_A(2,this.value);">
			<option value=""></option>
					
			</select>
			</td>
			
			<td>三级行业</td>
			<td><select name="thi_A" id="thi_A">
			<option value=""></option>
					
			</select>
			</td>
        </tr>---->
        <!-- --------------------------------------------                 -->
	  </table> 
  </form>
  </center>
  </body>
</html>

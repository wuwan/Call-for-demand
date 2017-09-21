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
    <title>填写需求征集信息</title>
<script type="text/javascript" src="js/jquery-1.4.js"></script>

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

<body>
<center>
    <h1 align="center">河北省重大技术需求征集表</h1>
<form action="shenhe.action"  method=post name="form1" onSubmit="return star()">
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
        <!-- --------------------------------------------                 -->
        <tr>
								<td width="20"><input name="tbgovbelong.cborder" value="${need.CNumber}" type="hidden" id="Role">
							</tr>
		<tr>
								<td width="20"><input name="tbgovbelong.cbid" value="${need.number}" type="hidden" id="Role">
							</tr>
		<tr>
								<td width="20"><input name="tbgovbelong.state" value="待审核" type="hidden" id="Role">
							</tr>
		<tr>
								<td width="20"><input name="tbgovbelong.state1" value="待审核" type="hidden" id="Role">
							</tr>
		<tr>
								<td width="20"><input name="tbgovbelong.cbAccount" value="${need.name}" type="hidden" id="Role">
							</tr>
        <tr>
        <td width="10%" style="color:red">管理处室</td>
		<!--      <td width="40%" colspan="6"><input type="text" name="tbgovbelong.cbnumber" class="full" value="${tbgovbelong.cbnumber}">
				    </td>-->		
		    <td width="40%" colspan="6">
		            <select name="tbgovbelong.cbnumber" id="tbgovbelong.cbnumber">  
                      <c:forEach items="${guanlii}" var="item">        
                      <option>${item.idname}</option>  
                      </c:forEach>                             
                      </select>  
		    </td>
	    </tr>
	  </table> 
	  <input type="submit" name="submit1" onclick="return confirm('确定退回吗')" value="退回">
				<input type="submit" name="submit2" onclick="return confirm('确定通过吗')" value="通过">
  </form>
  </center>
  </body>
</html>

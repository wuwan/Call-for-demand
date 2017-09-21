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
    <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
    <base href="<%=basePath%>">
    <title>需求管理</title>
    <link rel="stylesheet" type="text/css" href="http://piccache.cnki.net/kdn/kns/css/gb_min/ResultComp.min.css?v=" />
    <script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="js/gb.ResultPage.min.js?v=D59787997F3B8FCE" ></script>
    
</head>
<body>

    <a id="ys"></a>
    <div id="HeaderDiv">
       
<input type="hidden" id="hid_kLogin_headerUrl" name="hid_kLogin_headerUrl" value="http%3A//kns.cnki.net/KLogin/Request/GetKHeader.ashx%3Fcallback%3D%3F" />
<div class="searchCol">
<form action="query.action" method="post">    
<dl id="searchdiv">  
  <dd class="divsearch" id="ddSubmit" name="ddSubmit" onkeydown="if(event.keyCode==13){SubmitForm();return false;}">
        <b class="c7">输入检索条件：</b>
 <center>   
        <table id="txt" align="center">
           <tr>
           <td>
             <input id="txt_i" value="1" type="hidden" name="txt_i"></td>
           <td>   
             <input id="txt_c" value="4" type="hidden" name="txt_c"></td>
           </tr>
           <tr id="hidden_logical_txt" style="display:none">
                <td>
                    <select id="txt_1_key" name="txt_1_key">
                        <option value="and" selected>并且</option>
                        <option value="or">或者</option>
                        <option value="not">不含</option>
                    </select>
                </td>
            </tr>
            <tr id="txt_1" class="mainKey">
                <td class="aomBtn">
                    <a href="javascript:AddRowEx('txt','txt_i','txt_c');">
                        <img src="images/01.PNG" border="0">
                    </a><a href="javascript:DeleteRowSaveID('txt','txt_i','txt_c');">
                        <img src="images/02.PNG" border="0">
                    </a>
                </td>
                <td>
                  (
                  <select id="txt_1_sel" name="txt_1_sel" onchange="disableWordTimes(this);return false;" class="selectW1">
                        <option value="order" selected>需求编号</option>
                        <option value="zzbm">组织编码</option>
                        <option value="tbjg">填报机构</option>
                        <option value="state">审核状态</option>
                      
                    </select>
                    <input value="" id="txt_1_value1" name="txt_1_value1" size="10" maxlength="120" type="text" onfocus="if(KeywordVal(this.value)==false) this.value='';document.getElementById('currentid').value=this.id;" onkeypress="SignVal(this,'sign',event)" onkeyup="SignVal1(this)">

                     <select id="txt_1_special1" name="txt_1_special1" onchange="">
                        <option value="%">模糊</option>
                        <option value="=" selected>精确</option>
                    </select>
                    )
                </td>
            </tr>
            <tr>
            <td><input type="submit" id="btnSearch" value="检 索"></td>
            </tr>
        </table>
        </center>
      <input type="hidden" id="txt_1_extension" name="txt_extension" value="">
      <input type="hidden" id="txt_2_extension" name="txt_extension" value="">
      <input type="hidden" id="txt_3_extension" name="txt_extension" value="">
      <input type="hidden" id="txt_4_extension" name="txt_extension" value="">
  </dd>
</dl>
</form>

<input type="hidden" value="" name="cjfdcode" id="cjfdcode">
<input type="hidden" id="currentid" name="currentid" value="">

</div>
</div>
</body>
</html>

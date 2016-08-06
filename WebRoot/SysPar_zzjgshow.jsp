<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SysPar_zzjgshow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div>
     组织机构 <br>
    <table class="default" width="100%" >
			<col width="10%">
			<col width="20%">
			<col width="5%">
			<col width="20%">
			<col width="30%">
			<col width="15%">
			<tr class="title">
				<td>键值</td>
				<td>名称</td>
			    <td>人数</td>  
				<td>负责人</td>
				<td>操作</td>
			</tr>

			<!-- 遍历开始 -->
			<s:iterator value="#session.orgnizationlist" var="stu">
				<tr class="list">
					<td><s:property value="#stu.orgnizationid" /></td>
					<td><s:property value="#stu.orgnizationname" /></td>
					<td><s:property value="#stu.orgnizationtotalp" /></td>
					<td><s:property value="#stu.orgnizationcharge" /></td>
					<td><a href="<%=path%>/SystemParrateAction/sysParrate_orgnizationupdateRQ.action?stu.orgnizationid=<s:property value="#stu.orgnizationid"/>" onclick="javascript: return confirm('真的要修改吗？');">修改</a></td>
					
					
				</tr>
			</s:iterator>
			<!-- 遍历结束 -->
		</table>
		</div>
		<div><img alt="组织机构" src="images/zzjg.png" style="height: 740px;" > <br></div>
       
  </body>
</html>

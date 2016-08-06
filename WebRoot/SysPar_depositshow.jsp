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
    
    <title>My JSP 'SysPar_Loanshow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	#buttonGroup {
	padding-left: 10px;
	float: left;
	height: 35px;
}

.button {
	float: left;
	margin-right: 10px;
	padding-left: 10px;
	padding-right: 10px;
	font-size: 14px;
	width: 70px;
	height: 30px;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
	cursor: pointer;
	border-color: #77D1F6;
	border-width: 1px;
	border-style: solid;
	border-radius: 6px 6px;
	-moz-box-shadow: 2px 2px 4px #282828;
	-webkit-box-shadow: 2px 2px 4px #282828;
	background-image: -moz-linear-gradient(top, #EBEBEB, #BFBFBF);
	background-image: -webkit-gradient(linear, left top, left bottom, color-stop(0, #EBEBEB),
		color-stop(1, #BFBFBF));
}
	
	
	
	
	</style>

  </head>
  
  
  
  <body>
    存款利率 <br>
<%--     <div id="tips">
		<div id="buttonGroup">
			<div class="button"
				onmouseout="this.style.backgrsoundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/Operater_add.jsp">添加</a>
			</div>
			<div class="button"
				onmouseout="this.style.backgroundColor='';this.style.fontWeight='normal'"
				onmouseover="this.style.backgroundColor='#77D1F6';this.style.fontWeight='bold'">
				<a href="<%=path%>/Operater_select.jsp">查找</a>
			</div>
		</div>
	</div> --%>
	<div>
    <table class="default" width="100%" >
			<col width="10%">
			<col width="20%">
			<col width="5%">
			<col width="20%">
			<col width="30%">
			<col width="15%">
			<tr class="title">
				<td>键值</td>
				<td>利率</td>
				<td>税率</td>
			    <td>时间</td>  
				<td>定活</td>
				<td>操作</td>
			</tr>

			<!-- 遍历开始 -->
			<s:iterator value="#session.depositlist" var="stu">
				<tr class="list">
					<td><s:property value="#stu.depositkey" /></td>
					<td><s:property value="#stu.rate" /></td>
					<td><s:property value="#stu.interest" /></td>
					<td><s:property value="#stu.time" /></td>
					<td><s:property value="#stu.sign" /></td>
					<td><a href="<%=path%>/SystemParrateAction/sysParrate_depositupdateRQ.action?stu.depositkey=<s:property value="#stu.depositkey"/>" onclick="javascript: return confirm('真的要修改吗？');">修改</a></td>
					
					
				</tr>
			</s:iterator>
			<!-- 遍历结束 -->
		</table>
	</div>
  </body>
</html>

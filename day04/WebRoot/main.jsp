<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://www.5retc.com/taglib" prefix="etc"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
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
  <h1>主页</h1>
  <!-- 使用脚本方式直接显示 -->
    <div>
    	<%String val=(String)request.getAttribute("uname");
    	if(val!=null&&!val.equals(" ")){
    		%><font color='red'><%=val %></font><%
    	}
    	%>
    </div>
  <!-- 使用自定义标签显示 -->
  	<etc:PrintAttrTag attr="uname"/>  
  <!-- 使用EL显示 -->
  	<font color="red">${requestScope.uname}</font>
  	<div>密码：${param.pwd }</div>
  	<div>状态：${param.state }</div>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <table border="1" width="100%">
    	<tr>
    		<th>id</th>
    		<th>name</th>
    		<th>sex</th>
    		<th>age</th>
    		<th>major</th>
    	</tr>
    	<c:forEach items="${list }" var="a">
    	<tr>
    		<td>${a.id }</td>
    		<td>${a.name }</td>
    		<td>${a.sex }</td>
    		<td>${a.age }</td>
    		<td>${a.major }</td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>

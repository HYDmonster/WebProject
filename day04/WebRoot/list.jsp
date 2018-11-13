<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
    <table>
    	<tr>
    		<td>学号</td>
    		<td>姓名</td>
    		<td>性别</td>
    		<td>年龄</td>
    		<td>专业</td>
    		<td>成年/未成年</td> 
    	</tr>
    	<c:forEach items="${requestScope.list }" var="stu">
    		<tr>
    			<td>${stu.stuNo }</td>
    			<td>${stu.stuName }</td>
    			<td>${stu.stuSex }</td>
    			<td>${stu.stuAge }</td>
    			<td>${stu.stuMajor }</td>
    			<td>
    				<c:choose>
    					<c:when test="${stu.stuAge>=18 }">成年</c:when>
    					<c:otherwise><font color="red">未成年</font></c:otherwise>
    				</c:choose>
    		</tr>
    	</c:forEach>  	
    </table>
  </body>
</html>

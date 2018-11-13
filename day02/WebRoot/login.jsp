<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  <div style="color:red">${errmsg}</div>
   <h1>登陆</h1>
    <form action="loginServlet" method="post">
    账号: <input name="user"><br>
    密码: <input type="password" name="psw"><br>
  免登陆时间
  <select name="daylength">
  	<option value="-1">请选择</option>
  	<option value="3">3天</option>
  	<option value="7">7天</option>
  </select><br>
  <input type="submit" value="Login">
    </form>
  </body>
</html>

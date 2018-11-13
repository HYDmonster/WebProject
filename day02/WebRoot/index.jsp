<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	Cookie[] cookies=request.getCookies();
	String name=null,pwd=null;
	for(Cookie c :cookies){
		if(c.getName().equals("uname")){
			name=c.getValue();
		}
		if(c.getName().equals("upwd")){
			pwd=c.getValue();
		}
	}
	if(name!=null && pwd!=null){
		request.getRequestDispatcher("loginServlet?user="+name+"&psw="+pwd)
		.forward(request, response);
	}
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
    网站首页
  </body>
</html>

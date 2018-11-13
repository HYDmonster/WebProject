<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stuadd.jsp' starting page</title>
    
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
   	<h1>添加学生</h1> 
   	<form action="StudentAddServlet" method="post">
   		学号: <input name="no"><br>
  		 姓名: <input name="name"><br>
  		 性别
    		<select name="sex">
    			<option value="男">男</option>
    			<option value="女">女</option>
    		</select><br>
    	年龄 <input name="age" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');"><br>
    	专业
    		<select name="major">
    			<option value="计算机">计算机</option>
    			<option value="物联网">物联网</option>
    			<option value="计科">计科</option>
    			<option value="土木">土木</option>
    		</select><br>
    	<input type="submit" value="提交">
   </form>  
  </body>
</html>

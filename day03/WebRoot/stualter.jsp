<%@page import="com.cqjtu.edu.Servlet.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stualter.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <%
		//从request里取出student
		Student stu=(Student)request.getAttribute("stu");
	%>
  </head>
  
  <body>
    <h1>修改学生信息</h1>
    <form action="StudentAltServlet" method="post">
    	学号<input name="id" value="<%=stu.getStuNo() %>" readonly><br>  
  		 姓名<input name="name" value="<%=stu.getStuName()%>"><br>
  		 性别
    		<select name="sex">
    			<option value="男" <%if(stu.getStuSex().equals("男"))out.print("selected"); %>>男</option>
    			<option value="女" <%if(stu.getStuSex().equals("女"))out.print("selected"); %>>女</option>
    		</select><br>
    	年龄 <input name="age" value="<%=stu.getStuAge()%>" onkeyup="this.value=this.value.replace(/[^0-9-]+/,'');"><br>
    	专业
    		<select name="major">
    			<option value="计算机" <%if(stu.getStuSex().equals("计算机"))out.print("selected"); %>>计算机</option>
    			<option value="物联网" <%if(stu.getStuSex().equals("物联网"))out.print("selected"); %>>物联网</option>
    			<option value="计科" <%if(stu.getStuSex().equals("计科"))out.print("selected"); %>>计科</option>
    			<option value="土木" <%if(stu.getStuSex().equals("土木"))out.print("selected"); %>>土木</option>
    		</select><br>
    	<input type="submit" value="提交">
   </form>  
  </body>
</html>

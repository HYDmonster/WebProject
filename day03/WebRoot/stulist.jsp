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
    
    <title>My JSP 'stulist.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		table{
			border:1px solid gray;
			border-collapse:collapse;
			width:100%;
		}
		td{
			border:1px solid gray;
		}
	</style>
	<%
		//从request里取出集合
		List<Student>list=(List<Student>)request.getAttribute("list");
	%>
  </head>
  
  <body>
  <form action="StudentSearchServlet" >
  	<input type="text" id="searchstr" name="searchstr" class="textbox" size="20">
  	<input type="submit" value="搜索">
  </form>
    <table>
    	<tr>
    		<td>学号</td>
    		<td>姓名</td>
    		<td>性别</td>
    		<td>年龄</td>
    		<td>专业</td> 
    	</tr>
    	<%
    	if(list !=null){
    		for(Student s:list){
    			%>
    				<tr>
    					<td><%=s.getStuNo() %></td>
    					<td><%=s.getStuName() %></td>
    					<td><%=s.getStuSex() %></td>
    					<td><%=s.getStuAge() %></td>
    					<td><%=s.getStuMajor() %></td>
    					<td><a href="StudentDelServlet?id=<%=s.getStuNo() %>">删除</a>
    					<a href="OperateServlet?id=<%=s.getStuNo() %>&operate=<%="alter" %>">修改</a>
    				</tr>
    			<%
    		}
    	}
    	%>  		
    </table>
    <a href="OperateServlet?operate=<%="add" %>">添加</a>
  </body>
</html>

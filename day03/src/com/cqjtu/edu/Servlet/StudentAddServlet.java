package com.cqjtu.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.edu.dao.StudentDao;

public class StudentAddServlet extends HttpServlet {

	private StudentDao dao=new StudentDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String no=request.getParameter("no");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		int age=Integer.parseInt(request.getParameter("age"));	
		String major=request.getParameter("major");
		Student stu=new Student(no,name,sex,age,major);
		dao.addStudent(stu);
		List<Student>list=dao.queryAll();
		request.setAttribute("list", list);
		//跳转回列表页面
		request.getRequestDispatcher("stulist.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}

}

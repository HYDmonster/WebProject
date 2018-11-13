package com.cqjtu.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.edu.dao.StudentDao;

public class StudentDelServlet extends HttpServlet {
	private StudentDao dao=new StudentDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取参数id
		String id=request.getParameter("id");
		//调用dao方法删除
		dao.delById(id);
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

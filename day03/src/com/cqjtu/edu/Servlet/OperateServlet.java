package com.cqjtu.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.edu.dao.StudentDao;

public class OperateServlet extends HttpServlet {

	private StudentDao dao=new StudentDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operate=request.getParameter("operate");
		if(operate.equals("add")){
			request.getRequestDispatcher("stuadd.jsp").forward(request, response);
		}else if(operate.equals("alter")){
			//获取参数id
			String id=request.getParameter("id");
			Student stu=dao.searchByNo(id);
			request.setAttribute("stu", stu);
			request.getRequestDispatcher("stualter.jsp").forward(request, response);
		}	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}


}

package com.cqjtu.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cqjtu.edu.dao.StudentDao;

public class StudentSearchServlet extends HttpServlet {

	private StudentDao dao=new StudentDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String key=new String(request.getParameter("searchstr").getBytes("iso-8859-1"),"utf-8");
		//String str=request.getParameter("searchstr");
		List<Student>list=dao.search(key);
		request.setAttribute("resultNum", list.size());
		request.setAttribute("list", list);
		request.getRequestDispatcher("stuSearch.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

}

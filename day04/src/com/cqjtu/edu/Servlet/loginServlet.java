package com.cqjtu.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username=request.getParameter("user");
		String psw=request.getParameter("psw");
		String daylength=request.getParameter("daylength");
		if(username.equals("root")&&psw.equals("123456")){
			//������
			ServletContext sc=this.getServletContext();
			Integer count=(Integer)sc.getAttribute("count");
			if(count!=null)count++;
			else count=1;
			sc.setAttribute("count", count);
			//���û���������request��
			request.setAttribute("userName", username);
			//����ת�����ɴ����ݣ�
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else
			response.sendRedirect("fault.jsp");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
		
	}


}

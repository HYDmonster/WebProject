package com.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public loginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		String username=request.getParameter("user");
		String psw=request.getParameter("psw");
		String daylength=request.getParameter("daylength");
		if(username.equals("root")&&psw.equals("123456")){
			if(daylength!=null && !daylength.equals("-1")){
				int day=Integer.parseInt(daylength);
				Cookie cname=new Cookie("uname",username);
				Cookie cpwd=new Cookie("upwd",psw);
				cname.setMaxAge(day*24*3600);
				cpwd.setMaxAge(day*24*3600);
				response.addCookie(cname);
				response.addCookie(cpwd);
			}
			//将用户名保存在session
			HttpSession session=request.getSession();
			session.setAttribute("curName", username);
			//上下文
			ServletContext sc=this.getServletContext();
			Integer count=(Integer)sc.getAttribute("count");
			if(count!=null)count++;
			else count=1;
			sc.setAttribute("count", count);
			//将用户名保存在request中
			request.setAttribute("userName", username);
			//响应重定向（单纯跳转，不带数据）
			//response.sendRedirect("success.jsp");
			//请求转发（可带数据）
			request.getRequestDispatcher("success.jsp").forward(request, response);
		}else{
			//request.getRequestDispatcher("fault.jsp").forward(request, response);
			response.sendRedirect("fault.jsp");
		}
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}

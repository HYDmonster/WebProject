package com.cqjtu.edu.Servlet;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CountListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//从上下文中取出count
		String count=arg0.getServletContext().getAttribute("count").toString();
		ReadWriter.write(arg0.getServletContext().getRealPath("/"), count);
		//System.out.println(arg0.getServletContext().getRealPath("/"));
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//读count.txt文件
		try {
			int count=ReadWriter.read(arg0.getServletContext().getRealPath("/"));
			//将读到的人数存入上下文对象
			arg0.getServletContext().setAttribute("count", count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

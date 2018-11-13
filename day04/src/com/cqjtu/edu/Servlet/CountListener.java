package com.cqjtu.edu.Servlet;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CountListener implements ServletContextListener {
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//����������ȡ��count
		String count=arg0.getServletContext().getAttribute("count").toString();
		ReadWriter.write(arg0.getServletContext().getRealPath("/"), count);
		//System.out.println(arg0.getServletContext().getRealPath("/"));
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		//��count.txt�ļ�
		try {
			int count=ReadWriter.read(arg0.getServletContext().getRealPath("/"));
			//���������������������Ķ���
			arg0.getServletContext().setAttribute("count", count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.cqjtu.edu.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student>list=new ArrayList<Student>();
		list.add(new Student("101","hhu","Å®",22,"SS"));
		list.add(new Student("102","dbt","ÄÐ",18,"SC"));
		list.add(new Student("103","dgn","Å®",16,"SS"));
		list.add(new Student("104","uty","ÄÐ",20,"SC"));
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	

}

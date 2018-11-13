package com.cq.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import com.cq.C.Student;

public class StudentRequestController implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "����", "��", 21, "CS"));
		list.add(new Student(2, "����2", "��", 22, "CS"));
		arg0.setAttribute("list", list);
		//ָ��Ҫ��ת��jsp
		arg0.getRequestDispatcher("/index.jsp").forward(arg0, arg1);
	}

}

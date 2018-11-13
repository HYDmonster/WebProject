package com.cq.Controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.cq.C.Student;

public class StudentController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "张三", "男", 21, "CS"));
		list.add(new Student(2, "张三2", "男", 22, "CS"));
		//创建ModelAndView
		ModelAndView mv = new ModelAndView();
		//相当于rquest.setAttribute()
		mv.addObject("list", list);
		//指定要跳转的jsp
		mv.setViewName("/index.jsp");
		return mv;
		
	}

}

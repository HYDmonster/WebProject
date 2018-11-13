package com.cq.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cq.C.Student;

public class StudentAnnotionController {
	@RequestMapping("/stus")
	public ModelAndView queryStuList(){
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

package com.cd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cd.po.Student;
import com.cd.service.StudentService;

public class StudentController {
	@Autowired
	private StudentService studentService;
	@RequestMapping("/listStudent")
	public ModelAndView listStudent(){
		List<Student> list = this.studentService.getAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("/index.jsp");
		return mv;
	}

}

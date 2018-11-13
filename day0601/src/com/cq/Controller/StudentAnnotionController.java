package com.cq.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cq.C.Student;

public class StudentAnnotionController {
	@RequestMapping("/stus")
	public ModelAndView queryStuList(){
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "����", "��", 21, "CS"));
		list.add(new Student(2, "����2", "��", 22, "CS"));
		//����ModelAndView
		ModelAndView mv = new ModelAndView();
		//�൱��rquest.setAttribute()
		mv.addObject("list", list);
		//ָ��Ҫ��ת��jsp
		mv.setViewName("/index.jsp");
		return mv;
	}
}

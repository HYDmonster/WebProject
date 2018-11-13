package com.cd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cd.mapper.StudentMapper;
import com.cd.po.Student;

public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentMapper mapper;
	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}

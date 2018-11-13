package com.cd.mapper;

import java.util.List;

import com.cd.po.Student;

public interface StudentMapper {
	public List<Student> selectAll();
	public Student selectStuById(String stuid);
	
	public List<Student> selectByFirstName(String firstName);
	
	public void addStudent(Student stu);
	
	public void deleteStudentById(String id);
	
	public void updateStudentById(Student stu);
}

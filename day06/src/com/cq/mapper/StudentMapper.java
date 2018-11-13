package com.cq.mapper;

import java.util.List;

import com.cq.Servlet.Student;

public interface StudentMapper {
	public Student selectStuById(String stuid);
	
	public List<Student> selectByFirstName(String firstName);
	
	public void addStudent(Student stu);
	
	public void deleteStudentById(String id);
	
	public void updateStudentById(Student stu);
}

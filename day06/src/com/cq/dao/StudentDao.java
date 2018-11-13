package com.cq.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.cq.Servlet.Student;
import com.cq.mapper.StudentMapper;

public class StudentDao {
	public Student queryById(String id) throws IOException {
		Student stu = null;
		// 1.读取SqlMapConfig.xml配置文件
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// 创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 获得会话
		SqlSession session = factory.openSession();
		// 第一个参数：映射文件中select标签的id（statement的id）
		// 第二个参数：和映射文件中指定的parameterType类型相同的参数
		stu = session.selectOne("selectStuById", id);
		return stu;
	}
	public List<Student> selectByFirstName(String firstName) throws IOException {
		List<Student> list = null;
		// 1.读取SqlMapConfig.xml配置文件
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// 创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 获得会话
		SqlSession session = factory.openSession();
		list = session.selectList("selectByFirstName", firstName);
		return list;
	}
	public void addStudent(Student stu) throws IOException {
		// 1.读取SqlMapConfig.xml配置文件
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// 创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 获得会话
		SqlSession session = factory.openSession();

		session.insert("addStudent", stu);
		// 提交事务
		session.commit();
		session.close();
	}
	public void deleteStudentById(String id) throws IOException {
		// 1.读取SqlMapConfig.xml配置文件
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// 创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 获得会话
		SqlSession session = factory.openSession();
		session.delete("deleteStudentById", id);
		// 提交事务
		session.commit();
		session.close();
	}
	public void updateStudentById(Student stu) throws IOException {
		// 1.读取SqlMapConfig.xml配置文件
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// 创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// 获得会话
		SqlSession session = factory.openSession();
		session.update("updateStudentById", stu);
		// 提交事务
		session.commit();
		session.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//selectStuById
		/*StudentDao dao=new StudentDao();
		Student stu=dao.queryById("103");
		stu.printStu();
		//selectByFirstName
		List<Student>list=new ArrayList<Student>();
		list=dao.selectByFirstName("张");
		for(Student s :list){
			s.printStu();
		}
		//addStudent
		//Student newstu=new Student("100","里斯","男",25,"河海");
		//dao.addStudent(newstu);
		//deleteStudentById
		//dao.deleteStudentById("100");
		//updateStudentById
		Student s=new Student("103","张倩","女",23,"土木");
		dao.updateStudentById(s);*/	
		
		
		// 1.读取SqlMapConfig.xml配置文件
				String path = "SqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(path);
				// 创建会话工厂
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
				// 获得会话
				SqlSession session = factory.openSession();
				//mybatis自动生成mapper代理对象
				StudentMapper sm = session.getMapper(StudentMapper.class);
				Student stu=sm.selectStuById("103");
				stu.printStu();
				System.out.println(sm.selectStuById("103"));
	}
}

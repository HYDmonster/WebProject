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
		// 1.��ȡSqlMapConfig.xml�����ļ�
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// �����Ự����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// ��ûỰ
		SqlSession session = factory.openSession();
		// ��һ��������ӳ���ļ���select��ǩ��id��statement��id��
		// �ڶ�����������ӳ���ļ���ָ����parameterType������ͬ�Ĳ���
		stu = session.selectOne("selectStuById", id);
		return stu;
	}
	public List<Student> selectByFirstName(String firstName) throws IOException {
		List<Student> list = null;
		// 1.��ȡSqlMapConfig.xml�����ļ�
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// �����Ự����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// ��ûỰ
		SqlSession session = factory.openSession();
		list = session.selectList("selectByFirstName", firstName);
		return list;
	}
	public void addStudent(Student stu) throws IOException {
		// 1.��ȡSqlMapConfig.xml�����ļ�
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// �����Ự����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// ��ûỰ
		SqlSession session = factory.openSession();

		session.insert("addStudent", stu);
		// �ύ����
		session.commit();
		session.close();
	}
	public void deleteStudentById(String id) throws IOException {
		// 1.��ȡSqlMapConfig.xml�����ļ�
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// �����Ự����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// ��ûỰ
		SqlSession session = factory.openSession();
		session.delete("deleteStudentById", id);
		// �ύ����
		session.commit();
		session.close();
	}
	public void updateStudentById(Student stu) throws IOException {
		// 1.��ȡSqlMapConfig.xml�����ļ�
		String path = "SqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(path);
		// �����Ự����
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		// ��ûỰ
		SqlSession session = factory.openSession();
		session.update("updateStudentById", stu);
		// �ύ����
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
		list=dao.selectByFirstName("��");
		for(Student s :list){
			s.printStu();
		}
		//addStudent
		//Student newstu=new Student("100","��˹","��",25,"�Ӻ�");
		//dao.addStudent(newstu);
		//deleteStudentById
		//dao.deleteStudentById("100");
		//updateStudentById
		Student s=new Student("103","��ٻ","Ů",23,"��ľ");
		dao.updateStudentById(s);*/	
		
		
		// 1.��ȡSqlMapConfig.xml�����ļ�
				String path = "SqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(path);
				// �����Ự����
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
				// ��ûỰ
				SqlSession session = factory.openSession();
				//mybatis�Զ�����mapper�������
				StudentMapper sm = session.getMapper(StudentMapper.class);
				Student stu=sm.selectStuById("103");
				stu.printStu();
				System.out.println(sm.selectStuById("103"));
	}
}

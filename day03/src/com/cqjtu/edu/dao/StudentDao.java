package com.cqjtu.edu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cqjtu.edu.JDBC.DBConnection;
import com.cqjtu.edu.Servlet.Student;

public class StudentDao {
	public List<Student>queryAll(){
		List<Student>list=new ArrayList<Student>();
		Connection conn=DBConnection.getConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement("select * from Student");
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new Student(rs.getString(1)
						,rs.getString(2),rs.getString(3)
						,rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return list;
	}
	public void delById(String id){
		Connection conn=DBConnection.getConn();
		String sql="delete from Student where stuNo=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			//给参数赋值
			ps.setString(1, id);
			//执行
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
	}
	public void addStudent(Student stu){
		Connection conn=DBConnection.getConn();
		String sql = "insert into Student(stuNo,stuName,stuSex,stuAge,stuMajor) values(?,?,?,?,?)";
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getStuNo());
			ps.setString(2, stu.getStuName());
			ps.setString(3, stu.getStuSex());
			ps.setInt(4, stu.getStuAge());
			ps.setString(5, stu.getStuMajor());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
	}
	/*
	 * 数据库的查询
	 */
	public Student searchByNo(String no) {
		Student stu=new Student();
		Connection conn=DBConnection.getConn();
		String sql = "select * from Student where stuNo like '%" + no+ "%'";
		PreparedStatement pst;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				String id = result.getString(1);
				stu.setStuNo(id);
				String name = result.getString(2);
				stu.setStuName(name);
				String sex = result.getString(3);
				stu.setStuSex(sex);
				int age = result.getInt(4);
				stu.setStuAge(age);
				String major = result.getString(5);
				stu.setStuMajor(major);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}
	
	/*
	 * 更新数据库记录
	 */
	public void update(Student stu) {
		Connection conn=DBConnection.getConn();
		String sql = "update Student set stuName='" + stu.getStuName() 
				+ "', stuSex='"+ stu.getStuSex()+ "', stuAge="+ stu.getStuAge() 
				+ ", stuMajor='"+ stu.getStuMajor()+ "' where stuNo='" + stu.getStuNo()+"'";
		//String sql="update Student set stuName=?,stuSex=?,stuAge=?,stuMajor=? where stuNo='"+stu.getStuNo()+"'";
		PreparedStatement pst=null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			/*pst.setString(1, stu.getStuName());
			pst.setString(2, stu.getStuSex());
			pst.setInt(3, stu.getStuAge());
			pst.setString(4, stu.getStuMajor());*/
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBConnection.close(null, pst, conn);
		}
	}
	/*
	 * 数据库的查询
	 */
	public List<Student> search(String key) {
		List<Student> stuInfos = new ArrayList();
		Connection conn=DBConnection.getConn();
		String sql = "select * from Student where stuNo like '%" + key
				+ "%' or stuName like '%" + key + "%' or stuSex like '%" + key
				+ "%' or stuAge like '%" + key + "%' or stuMajor like '%" + key
				+ "%'";
		PreparedStatement pst=null;
		try {
			pst = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				Student stu = new Student();
				String no = result.getString(1);
				stu.setStuNo(no);
				String name = result.getString(2);
				stu.setStuName(name);
				String sex = result.getString(3);
				stu.setStuSex(sex);
				int age = result.getInt(4);
				stu.setStuAge(age);
				String major = result.getString(5);
				stu.setStuMajor(major);
				stuInfos.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuInfos;
	}
}

package com.cqjtu.edu.Servlet;

public class Student {
	String stuNo;
	String stuName;
	String stuSex;
	int stuAge;
	String stuMajor;
	public Student(String no,String name,String sex,int age,String major){
		this.stuNo=no;
		this.stuName=name;
		this.stuSex=sex;
		this.stuAge=age;
		this.stuMajor=major;
	}
	public Student(){
		this.stuNo=null;
		this.stuName=null;
		this.stuSex=null;
		this.stuAge=0;
		this.stuMajor=null;
	}
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getStuMajor() {
		return stuMajor;
	}
	public void setStuMajor(String stuMajor) {
		this.stuMajor = stuMajor;
	}
	
}

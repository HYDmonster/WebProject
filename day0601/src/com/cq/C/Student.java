package com.cq.C;

public class Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private String major;
	public Student(int i,String n,String s,int a,String m){
		this.id=i;
		this.name=n;
		this.sex=s;
		this.age=a;
		this.major=m;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", major=" + major + "]";
	}
}

package com.neosoft.model;

public class Student {

	private int stid;
	private String stname;
	private String stcourse;
	private int marks;
	public Student( int stid,String stname, String stcourse, int marks) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.stcourse = stcourse;
		this.marks = marks;
	}
public Student() {
		// TODO Auto-generated constructor stub
	}
		public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStcourse() {
		return stcourse;
	}
	public void setStcourse(String stcourse) {
		this.stcourse = stcourse;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [stid=" + stid + ", stname=" + stname + ", stcourse=" + stcourse + ", marks=" + marks + "]";
	}
	
	
	
	
}

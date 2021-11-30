package com.neosoft.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.model.Student;

public class StudentController {

	public static List<Student> getAllStudents() {
		List<Student> students = new ArrayList<Student>();
		Connection con = JDBCProperties.getConnection();

		try {
			String query = "SELECT * FROM mydb.student";

			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				students.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;

	}

	// for student insert
	public static boolean insertStudent(Student student) {

		Connection con = JDBCProperties.getConnection();
		PreparedStatement pst;
		try {
			String insertquery = "insert into student(stname,course,marks)values(?,?,?)";
			pst = con.prepareStatement(insertquery);
			pst.setString(1, student.getStname());
			pst.setString(2, student.getStcourse());
			pst.setInt(3, student.getMarks());
			// System.out.println("student inserted sucess");
			return pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static Student SearchStudentById(int sid) {

		Connection con = JDBCProperties.getConnection();
		Student s=null;
		PreparedStatement pst;
		try {
			String insertquery = "select * from student where sid=?";
			pst = con.prepareStatement(insertquery);
			pst.setInt(1, sid);
			// System.out.println("student inserted sucess");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				s=new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				break;
				// System.out.println("added sucess");
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	
	public static boolean deleteStudentById(int sid) {

		Connection con = JDBCProperties.getConnection();
		
		PreparedStatement pst;
		try {
			
			
			String insertquery = "delete from student where sid=?";
			pst = con.prepareStatement(insertquery);
			pst.setInt(1, sid);
			
			return pst.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	public static boolean updateStudentById(int sid,int marks) {

		Connection con = JDBCProperties.getConnection();
		
		PreparedStatement pst;
		try {
			
			
			String insertquery = "update student set marks=? where sid=?";
			pst = con.prepareStatement(insertquery);
			pst.setInt(1, marks);
			pst.setInt(2, sid);
			return pst.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	

}

package com.neosoft.viewservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;
import com.neosoft.model.Student;
@WebServlet(urlPatterns = "/searchServlet")
public class searchstudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		int sid=Integer.parseInt(req.getParameter("stdid"));
		Student s=StudentController.SearchStudentById(sid);
		out.println("StudentId:"+s.getStid()+"<br>");
		out.println("Student Name:"+s.getStname()+"<br>");
		out.println("StudentCourse:"+s.getStcourse()+"<br>");
		out.println("Student Marks:"+s.getMarks()+"<br>");
		
		out.close();
	}

	
}

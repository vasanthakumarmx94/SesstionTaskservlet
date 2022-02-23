package com.neosoft.viewservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.neosoft.controller.StudentController;
import com.neosoft.model.Student;
@WebServlet(urlPatterns = "/displayall")
public class displayAllstudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Employees</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		

		List<Student> list=StudentController.getAllStudents();
		 Gson json = new Gson();
		 
			
			List<Student> lst=StudentController.getAllStudents();
			
			String responsejsonstrin=json.toJson(lst);
			out.println(responsejsonstrin);
			
	
//		out.println("<table class='table table-bordered table-striped'>");
//		out.println("<tr><th>StudentId</th><th>Student Name</th><th>Course</th><th>Marks</th></th><th colspan='2'>Action</th></tr>");
//		for (Student bean : list) {
//			out.println("<tr><td>" + bean.getStid() + "</td><td>" + bean.getStname() + " </td><td>" + bean.getStcourse()
//					+ "</td><td> " + bean.getMarks() + "</td><td><a href='EditEmployeeForm?id=" + bean.getStid()
//					+ "'><button class='btn btn-primary'> Edit</button></a></td><td><a href='DeleteEmployee?id=" + bean.getStid() + "'><button class='btn btn-danger'> Delete</button></a></td></tr>");
//		}
//		out.println("</table>");
//		
//		out.println("<h2><a href='studentdashboard.html'><button>Got Home</button></a></h2>");
//		out.println("</body>");
//		
//		out.print("</html>");
		
		out.close();
	}
	
	
	

}

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
@WebServlet(urlPatterns = "/registrationform")
public class RegistrationFormServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		//jdbc controller class
		Student student=new Student();
		
		student.setStname(req.getParameter("stname"));
		student.setStcourse(req.getParameter("stcourse"));
		student.setMarks(Integer.parseInt(req.getParameter("stmarks")));
		
		try {
			if(StudentController.insertStudent(student)==false) {
				out.print("registration sucess");
			}else {
				out.print("registration NotDone");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		out.close();
	}
	
	
	
}

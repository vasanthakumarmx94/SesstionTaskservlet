package com.neosoft.viewservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;


@WebServlet(urlPatterns = "/updateServlet")
public class updatestudentservlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int sid=Integer.parseInt(req.getParameter("stdid"));
		
		int marks=Integer.parseInt(req.getParameter("umarks"));
		
		if(StudentController.updateStudentById(sid,marks)==false) {
			out.print("Update Successfully");
		}
		else {
			out.print("update NotDone");
		}
		
		
	}
	
	

}

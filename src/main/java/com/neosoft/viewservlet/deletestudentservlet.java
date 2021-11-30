package com.neosoft.viewservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;


@WebServlet(urlPatterns = "/deleteServlet")
public class deletestudentservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int sid=Integer.parseInt(req.getParameter("stdid"));
		
		if(StudentController.deleteStudentById(sid)==false) {
			out.print("Deleted Successfully");
		}
		else {
			out.print("Deleted NotDone");
		}
		
		
		
	}
	
	
	
	

}

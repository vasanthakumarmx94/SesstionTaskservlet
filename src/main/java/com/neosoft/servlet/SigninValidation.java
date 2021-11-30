package com.neosoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signinvalidate")
public class SigninValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String uname = req.getParameter("txtuser");
		String upass = req.getParameter("txtpass");
		if (uname.toLowerCase().equals("admin") && upass.equals("admin123")) {
			req.getRequestDispatcher("wellcome").forward(req, resp);
			req.getRequestDispatcher("Signin.html").include(req, resp);

		} else {
			out.print("<h3><font color='red'>invalid user..</font></h3>");
			out.print("<h3><a href='RegisterUser.html'>Click here for Registration</a></h3>");
			
			req.getRequestDispatcher("Signin.html").include(req, resp);

		}

		out.close();

	}
}

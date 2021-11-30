package com.neosoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/userregister")
public class userRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Add User</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");

		
		out.println("<div class='container'>");

		List<Users> user = new ArrayList<Users>();

		String name = req.getParameter("fname");
		String mobile = req.getParameter("mobile");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (req.getParameter("password").equals(req.getParameter("cpassword"))) {
			Users u=new Users(name,mobile,email,address,username,password);
			user.add(u);
			out.print("<h4>User Registerd successfully</h4>");
			req.getRequestDispatcher("Signin.html").include(req, resp);

		} else {

			out.print("<h4>Please verify password and confirm password should be same</h4>");
			req.getRequestDispatcher("RegisterUser.html").include(req, resp);

		}
		out.println("</body>");
		out.print("</html>");
		out.close();
	}

}

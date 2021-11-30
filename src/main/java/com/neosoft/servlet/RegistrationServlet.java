package com.neosoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/registerservlet")
public class RegistrationServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int age = 0;
		String uname=req.getParameter("txtuname");
		String dob=req.getParameter("dob");
		
		
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
			Date d=formatter.parse(dob);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(d);
			int year = calendar.get(Calendar.YEAR);
			int month=calendar.get(Calendar.MONTH);
			int day=calendar.get(Calendar.DAY_OF_MONTH);
			//out.println(year+"-"+month+"-"+day);
			//out.println(d.getMonth());
			
			LocalDate now = LocalDate.now();
			age= now.getYear() - year;
			
			//LocalDate Birth = LocalDate.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
//			Period diff = Period.between(Birth, now);
//			out.println("%d"+ diff.getYears());
//			long diffInYears = ChronoUnit.YEARS.between(Birth, now);
//			out.println(diffInYears);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	
		
		String qualification=req.getParameter("qalification");
		String gender=req.getParameter("gender");
		String course=req.getParameter("course");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobile");
		out.println("<h2>Register Successfully</h2>");
		out.println("<table border='2'>");
		out.println("<caption><h1>Registerd Data</h1></Caption>");
		out.println("<tr><th>UserName:</th><td>"+uname+"</td>");
		out.println("<tr><th>Age:</th><td>"+age+"</td>");
		out.println("<tr><th>Qualification:</th><td>"+qualification+"</td>");
		out.println("<tr><th>Gender:</th><td>"+gender+"</td>");
		out.println("<tr><th>course:</th><td>"+course+"</td>");
		out.println("<tr><th>email:</th><td>"+email+"</td>");
		out.println("<tr><th>mobile:</th><td>"+mobile+"</td>");
		
		out.println("</table>");
		
		
		
	}
	
}

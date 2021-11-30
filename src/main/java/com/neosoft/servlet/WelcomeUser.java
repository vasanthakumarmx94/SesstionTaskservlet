package com.neosoft.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/wellcome")
public class WelcomeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<font color='green'><h3>WELCOME Admin <h3></font>");
		
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

		if(timeOfDay >= 0 && timeOfDay < 12){
		           out.println("<h2>Good morning</h2>");
		}else if(timeOfDay >= 12 && timeOfDay < 16){
			out.println("<h2>Good Afternoon</h2>") ;
		}else if(timeOfDay >= 16 && timeOfDay < 21){
			out.println("<h2>Good Evening</h2>") ;
		}else if(timeOfDay >= 21 && timeOfDay < 24){
			out.println("<h2>Good night</h2>") ;
		}
		
		out.close();
		
	}
	
	
	
}

package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewdetails")
public class RegDetails extends HttpServlet {
	
	PrintWriter out=null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html");
		out=resp.getWriter();
		String username=(String)req.getAttribute("userName");
		String pswd=(String)req.getAttribute("password");
		String emailId=(String)req.getAttribute("userEmail");
		String mob=(String)req.getAttribute("userMobile");
		out.println("UserName is :"+username+"<br>");
		out.println("Password is :"+pswd+"<br>");
		out.println("Email Id is :"+emailId+"<br>");
		out.println("Mobile No is :"+mob+"<br>");
		
		out.println("<html><body><a href='index.html'>Go To Login</a></body></html>");
		
	
	}
}

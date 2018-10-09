package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gallery")
public class Gallery extends HttpServlet {
	
	PrintWriter out=null;
	int count = 1;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		out= resp.getWriter();
		resp.setContentType("text/html");
		out.println("No of views "+(count++));
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<form action='image'>");
		out.println("<a href='image?mobid=nokia1&mobname=Nokia+1110&price=1499'><img src='images/noika1110.jpeg' alt='Image not found' height='350px' width='300px'/></a>");
		out.println("<a href='image?mobid=nokia2&mobname=Nokia+1280&price=1599'><img src='images/nokia1280.jpeg' alt='Image not found' height='350px' width='300px'/></a>");
		out.println("<a href='image?mobid=nokia3&mobname=Nokia+3310&price=1199'><img src='images/nokia3310.jpeg' alt='Image not found' height='350px' width='300px'/></a>");
		out.println("<a href='image?mobid=nokia4&mobname=Nokia+6600&price=1699'><img src='images/nokia6600.jpeg' alt='Image not found' height='350px' width='300px'/></a>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

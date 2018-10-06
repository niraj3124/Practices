package com.cg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoTask
 */
@WebServlet(urlPatterns={"*.do"})
public class DemoTask extends HttpServlet {
	
	PrintWriter out = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		  out = resp.getWriter();
		  
		  out.println("<html>");
		  out.println("<head></head>");
		  out.println("<body>");
		  out.println("<a href='add.do'>ADD</a>");
		  out.println("<a href='update.do'>UPDATE</a>");
		  out.println("<a href='delete.do'>DELETE</a>");
		  out.println("<a href='select.do'>SELECT</a>");
		  out.println("</body>");
		  out.println("</html>");
		  
		  String option = req.getServletPath();
			System.out.println(option);
			switch (option) {
			case "/add.do":
				//add(req,resp);
				out.println("ADDED");
				System.out.println("Added");
				break;
			case "/update.do":
				//update(req,resp);
				out.println("UPDATED");
				System.out.println("Updated");
				break;
			case "/delete.do":
				//delete(req,resp);
				out.println("DELETED");
				System.out.println("Deleted");
				break;
			case "/select.do":
				//select(req,resp);
				out.println("SELECTED");
				System.out.println("Selected");
				
				break;
			}  
		  }
		
	
	
	/*public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		out = resp.getWriter();
		out.println("ADDED");
		System.out.println("Added");
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		out = resp.getWriter();
		out.println("UPDATED");
		System.out.println("Updated");
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		out = resp.getWriter();
		out.println("DELETED");
		System.out.println("Deleted");
	}
	
	public void select(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		out = resp.getWriter();
		out.println("SELECTED");
		System.out.println("Selected");
	}
	*/
}

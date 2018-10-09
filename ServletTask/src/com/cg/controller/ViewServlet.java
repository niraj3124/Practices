package com.cg.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regserv")
public class ViewServlet extends HttpServlet {

	PrintWriter out=null;
	RequestDispatcher rd=null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		out=resp.getWriter();
		String name=req.getParameter("userName");
		String pwd=req.getParameter("userPass");
		String cpwd = req.getParameter("confPass");
		String email=req.getParameter("userEmail");
		String mobile=req.getParameter("userMobile");
		String target=null;
		
		
		target="viewdetails";
		if(pwd.equals(cpwd)){
		req.setAttribute("userName", name);
		req.setAttribute("password", pwd);
		req.setAttribute("userEmail", email);
		req.setAttribute("userMobile", mobile);
		rd=req.getRequestDispatcher(target);
		rd.forward(req, resp);
		}
		else
		{
			out.println("Password mismatch");
		}
	}
}
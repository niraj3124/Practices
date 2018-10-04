package com.cg.ems.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDAOImpl;
import com.cg.ems.dao.IEmployeeDAO;
import com.cg.ems.exception.EmployeeIssueException;
import com.cg.ems.ui.Client;

public class EmployeeServiceImpl implements IEmployeeService {

	IEmployeeDAO  edao=null;
	
	@Override
	public void validateEmail(String email) throws EmployeeIssueException {
		String check = "[a-z]{1,}[0-9]{0,}[@][a-z]{3,}[.][Cc][Oo][Mm]";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(email);
		if(!m.find())
		{
			System.out.println("Invalid EmailId");
		}
	}

	@Override
	public int addEmployee(Employee emp) throws EmployeeIssueException {
		//logic  like adding mr or mrs based on gender or age...
		emp.setName(" Mr. "+emp.getName());
		edao=new EmployeeDAOImpl();
		int eid=edao.addEmployee(emp);
		return eid;
	}

	@Override
	public Employee retrieveByEmployeeId(int emp_Id) throws EmployeeIssueException {
		// TODO Auto-generated method stub
		edao=new EmployeeDAOImpl();
		return edao.retrieveByEmployeeId(emp_Id);
		//return null;
	}

	@Override
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException {
		edao=new EmployeeDAOImpl();
		return edao.retrieveAllEmployeeinfo();
	}

	@Override
	public void deleteEmployee(int emp_Id) throws EmployeeIssueException {

		edao = new EmployeeDAOImpl();
		edao.deleteEmployee(emp_Id);
		
	}

	@Override
	public void updateEmployee(int emp_Id) throws EmployeeIssueException {
		
		edao = new EmployeeDAOImpl();
		edao.updateEmployee(emp_Id);
	}

	@Override
	public void validateName(String name) throws EmployeeIssueException{
		String check1 = "[A-Z]{1,}[a-z]{0,}";
		Pattern p1 = Pattern.compile(check1);
		Matcher m1 = p1.matcher(name);
		if(!m1.find())
		{
			System.out.println("Invalid Name");
		}
	}

	@Override
	public void validateMobile(String mob) throws EmployeeIssueException {
		
		String check2 = "^[6789][0-9]{9}";
		Pattern p2 = Pattern.compile(check2);
		Matcher m2 = p2.matcher(mob);
		if(!m2.find())
		{
			System.out.println("Invalid Mobile Number");
		}
	}	

}

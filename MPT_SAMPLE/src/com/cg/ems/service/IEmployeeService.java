package com.cg.ems.service;

import java.util.ArrayList;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeIssueException;

public interface IEmployeeService {

	//validation
	public void validateEmail(String email) throws EmployeeIssueException;
	public int addEmployee(Employee emp) throws EmployeeIssueException;
	public Employee retrieveByEmployeeId(int emp_Id) throws EmployeeIssueException;
	public ArrayList<Employee> retrieveAllEmployeeinfo() throws EmployeeIssueException;
	public void deleteEmployee(int emp_Id) throws EmployeeIssueException;
	public void updateEmployee(int emp_Id) throws EmployeeIssueException;
	public void validateName(String name) throws EmployeeIssueException;
	public void validateMobile(String mob) throws EmployeeIssueException;
	
	
}

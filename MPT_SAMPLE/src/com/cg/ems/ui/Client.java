package com.cg.ems.ui;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeIssueException;
import com.cg.ems.service.EmployeeServiceImpl;
import com.cg.ems.service.IEmployeeService;

public class Client {
	static Scanner scanner = new Scanner(System.in);
	static Connection con = null;
	static IEmployeeService eserv = null;

	public static void main(String[] args) throws EmployeeIssueException {
		
		System.out.println("===EmployeemanagementSystem===");
		System.out.println("1. Add employee Info");
		System.out.println("2. Delete employee Info");
		System.out.println("3. Update employee Info");
		System.out.println("4. Retrieve employee by id");
		System.out.println("5. Retrieve All employee Info");
		System.out.println("6. exit");
		System.out.println();
		System.out.println("please enter option : ");
		System.out.println();
		int option = scanner.nextInt();
		switch (option) {

		case 1:
			try {
				
				System.out.println("enter name ");
				String name = scanner.next();
				eserv.validateName(name);
				
				System.out.println("enter email ");
				String email = scanner.next();
				eserv.validateEmail(email);
				
				System.out.println("enter sal");
				int sal = scanner.nextInt();
				
				System.out.println("enter mobile ");
				String mob = scanner.next();
				eserv.validateMobile(mob);
				
				com.cg.ems.bean.Employee emp = new com.cg.ems.bean.Employee();
				emp.setName(name);
				emp.setMail(email);
				emp.setSal(sal);
				emp.setMobile(mob);
				// validate it
				// if
				int empid = addEmployee(emp);
				System.out.println("data is added!!! ur emp id is : " + empid);
				break;
			} catch (EmployeeIssueException em) {
					System.err.println("exception occured :: "+em.getMessage());
			}
			break;
			
		case 2:
			try{
				System.out.println("eneter the id u wanna delete...");
				int searchId = scanner.nextInt();
				deleteEmployee(searchId);			
			}
			catch (EmployeeIssueException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;
		case 3:
			try
			{
				System.out.println("enter the id u wanna update...");
				int searchId = scanner.nextInt();
				updateEmployee(searchId);
				System.out.println("Enter option between 1-4");
				int op = scanner.nextInt();
				switch(op)
				{
				case 1:
					System.out.println("Enter new name you want to update : ");
					String name = scanner.next();
					break;
				case 2:
					System.out.println("Enter new email id you want to update : ");
					String email = scanner.next();
					break;
				case 3:
					System.out.println("Enter new number you want to update : ");
					String mob = scanner.next();
					break;
				case 4:
					System.out.println("Enter new salary you want to update : ");
					String sal = scanner.next();
					break;
				default:
					System.out.println("Please Enter option between 1-4");
					break;
				}
			}
			catch (EmployeeIssueException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;
		case 4:
			try {
			System.out.println("enter the id u wanna search...");
			int searchId = scanner.nextInt();
			Employee empList1=retrieveByEmployeeId(searchId);
			System.out.println(empList1);
			
			} 
			catch (EmployeeIssueException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;
		case 5:
			try {	
				ArrayList<Employee> empList=retrieveAll();
				//empList.stream().forEach(System.out::println);
				for(Employee e:empList)
				{
					System.out.println(e);
				}
				
			} catch (EmployeeIssueException e) {
				// TODO Auto-generated catch block
				System.err.println(e.getMessage());
			}
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("please enter a valid option between 1-6");
		}
	}

	private static Employee retrieveByEmployeeId(int empId) throws EmployeeIssueException {
		// TODO Auto-generated method stub
//		ArrayList<Employee> empid = retrieveByEmployeeId(emp);
		eserv = new EmployeeServiceImpl();
		return eserv.retrieveByEmployeeId(empId);
		//return empid;
	}


	private static ArrayList<Employee> retrieveAll() throws EmployeeIssueException {
	
		eserv=new EmployeeServiceImpl();
		return eserv.retrieveAllEmployeeinfo();
	}

	static int addEmployee(com.cg.ems.bean.Employee employee) throws EmployeeIssueException {

		eserv = new EmployeeServiceImpl();
		return eserv.addEmployee(employee);

	}
	
	static void deleteEmployee(int emp_Id) throws EmployeeIssueException
	{
		eserv = new EmployeeServiceImpl();
		eserv.deleteEmployee(emp_Id);
	}
	
	static void updateEmployee(int emp_Id) throws EmployeeIssueException
	{
		eserv = new EmployeeServiceImpl();
		eserv.updateEmployee(emp_Id);
	}

}

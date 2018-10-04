package com.cg.ems.test;

import java.sql.SQLException;

import org.junit.*;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDAOImpl;
import com.cg.ems.dao.IEmployeeDAO;
import com.cg.ems.exception.EmployeeIssueException;


public class TestCase {

	static IEmployeeDAO edao = null;
	
	@BeforeClass
	public static void init()
	{
		edao=new EmployeeDAOImpl();
	}
	
	@Test
	public void addEmployeeTest()
	{
		Employee emp = new Employee();
		emp.setName("Ajay");
		emp.setMail("ajay@gmail.com");
		emp.setMobile("9874562315");
		emp.setSal(50000);
		try 
		{
			Assert.assertEquals(1011, edao.addEmployee(emp));
		} 
		catch (EmployeeIssueException | NullPointerException | ExceptionInInitializerError e) {
			System.out.println("Error!!"+e.getMessage());
		}
		
	}
}

package com.cg.ui;


import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bean.Department2;
import bean.Employee2;

public class TestOneToMany {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		
		Department2 d1 = new Department2();
		d1.setDeptid(10);
		d1.setDeptName("IT");
		
		Department2 d2 = new Department2();
		d2.setDeptid(20);
		d2.setDeptName("ADMIN");
		
		Employee2 e1 = new Employee2();
		//e1.setEmpid(10001);
		e1.setEmpName("Niraj");
	    e1.setEmpSal(2000.0F);	
	    
	    Employee2 e2 = new Employee2();
	    //e2.setEmpid(10002);
		e2.setEmpName("Dhiraj");
	    e2.setEmpSal(2000.0F);
	    
	    Employee2 e3 = new Employee2();
	    //e3.setEmpid(10003);
		e3.setEmpName("Rohan");
	    e3.setEmpSal(2000.0F);
	    
	    Employee2 e4 = new Employee2();
	   // e4.setEmpid(10004);
		e4.setEmpName("Monu");
	    e4.setEmpSal(2000.0F);
	    
	    HashSet<Employee2> itDepEmpL = new HashSet<Employee2>();
	    HashSet<Employee2> adminDepEmpL = new HashSet<Employee2>();
	    
	    d1.addEmployee(e1);
	    d1.addEmployee(e4);
	    
	    d2.addEmployee(e2);
	    d2.addEmployee(e3);
	    
	   /* d1.setEmpset(itDepEmpL);
	    d2.setEmpset(adminDepEmpL);*/
	    
	    em.merge(d1);
	    em.merge(d2);
	    System.out.println("DATA ADDED");
	    et.commit();

	}

}



// a different object with the same identifier value was already associated with the session: 
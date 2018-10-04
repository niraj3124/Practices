package com.cg.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.bean.Employee;
import com.cg.bean.Manager;
import com.cg.util.JPAUtil;



public class TestEmpInhDemo {
	
	
	
	public static void main(String args[])
	{
		
		Employee e1 = new Employee();
		e1.setEmpName("Niraj");
		e1.setEmpSal(250000);
		
		Employee e2 = new Employee();
		e2.setEmpName("Dhiraj");
		e2.setEmpSal(350000); 
		
		Manager mgr1 = new Manager();
		mgr1.setEmpName("Sagar");
		mgr1.setEmpSal(2500000);
		mgr1.setDeptName("Training");
		
		
		EntityManager em = JPAUtil.getEntMgr();
		EntityTransaction tr = null;
		tr = em.getTransaction();
		tr.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(mgr1);
		tr.commit();
		System.out.println("DATA ADDED");
	}

}

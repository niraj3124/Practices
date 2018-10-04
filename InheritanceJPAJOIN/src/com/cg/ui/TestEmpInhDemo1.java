package com.cg.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.bean.Employee1;
import com.cg.bean.Manager1;
import com.cg.util.JPAUtil;



public class TestEmpInhDemo1 {
	
	
	
	public static void main(String args[])
	{
		
		Employee1 e1 = new Employee1();
		e1.setEmpName("Niraj");
		e1.setEmpSal(250000);
		
		Employee1 e2 = new Employee1();
		e2.setEmpName("Dhiraj");
		e2.setEmpSal(350000); 
		
		Manager1 mgr1 = new Manager1();
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

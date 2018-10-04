package com.cg.dao;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.cg.bean.Stu;
import com.cg.util.JPAUtil;

public class StuDaoImpl implements IStudentDao{
	
	EntityManager entiManager=null;
	EntityTransaction entTrans = null;
	
	

	public StuDaoImpl() {
		entiManager = JPAUtil.getEntMgr();
	}

	@Override
	public void addStudent(Stu stu) {
		entTrans  = entiManager.getTransaction();
		entTrans.begin();
		entiManager.persist(stu);
		entTrans.commit();
	}

	@Override
	public List<Stu> getAllStu() {
		
		String stuQuery = "SELECT s from Stu s";
		Query myQuery = entiManager.createQuery(stuQuery,Stu.class);
		List<Stu> stuList = myQuery.getResultList();
		return stuList;

		
		
	}

	@Override
	public Stu getStuById(int rNo) {
		
		Stu stu= entiManager.find(Stu.class, rNo);
		return stu;
	}

	@Override
	public List<Stu> getStuByName(String name) {

		String selQuery = "SELECT s FROM Stu s where s.name=:sname";
		TypedQuery query = entiManager.createQuery(selQuery,Stu.class);
		query.setParameter("sname", name);
		List<Stu> stL = query.getResultList();
		return stL;
	}

	@Override
	public Stu deleteByRollNo(int rNo) {
		entTrans  = entiManager.getTransaction();
		entTrans.begin();
		Stu st = entiManager.find(Stu.class,rNo);
		entiManager.remove(st);
		entTrans.commit();
		return st;
		
		
	}

	@Override
	public void updateStudent(Stu stu) {
		entTrans  = entiManager.getTransaction();
		entTrans.begin();
		Stu st = entiManager.find(Stu.class, stu.getRollno());
		entiManager.merge(stu);
		entTrans.commit();
	}

	
}

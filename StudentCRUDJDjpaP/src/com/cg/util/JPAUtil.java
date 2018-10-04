package com.cg.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
public static EntityManager getEntMgr()
{

	EntityManagerFactory entFact= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em= entFact.createEntityManager();

	return em;
	
}
}

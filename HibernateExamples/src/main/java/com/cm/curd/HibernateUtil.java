package com.cm.curd;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory factory = cfg.buildSessionFactory();
			return factory;
		}catch(Throwable e){
			System.out.println("Failed to create SessionFactory Object....."+e);
			throw new ExceptionInInitializerError(e);
		}
		
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

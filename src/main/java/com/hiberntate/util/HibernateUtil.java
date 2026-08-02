package com.hiberntate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Students;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			Configuration cfg = new Configuration();
			
			cfg.configure();
			cfg.addAnnotatedClass(Students.class);
			
			sessionFactory = cfg.buildSessionFactory();
			
			return sessionFactory;
		}
		else {
			return sessionFactory;
		}
	}
	
	
}

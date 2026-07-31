package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Students;

public class HibernateOperations {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Students.class);
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		insert(session);
		
		
	}

	private static void insert(Session session) {
		Students student = new Students(2,"kvs",29);
		
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
	}
}

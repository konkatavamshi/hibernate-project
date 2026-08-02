package com.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Students;
import com.hiberntate.util.HibernateUtil;

public class HibernateOperations {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		//insert(session);
		
		//select(session);
		
		//update(session);
		
		//delete(session);
		
		//dirtyChecking(session);
		
	}

	private static void dirtyChecking(Session session) {
		session.beginTransaction();
		Students student = session.find(Students.class, 2);
		student.setAge(28);
		session.getTransaction().commit();
	}

	private static void delete(Session session) {
		session.beginTransaction();
		Students student = new Students(3,"",0);
		session.remove(student);
		session.getTransaction().commit();
	}

	private static void update(Session session) {
		session.beginTransaction();
		Students student = session.find(Students.class, 1);
		student.setAge(27);
		session.merge(student);
		session.getTransaction().commit();
	}

	private static void select(Session session) {
		Students student = session.find(Students.class, 1);
		System.out.println(student);
	}

	private static void insert(Session session) {
		Students student = new Students(3,"ssmb",50);
		session.beginTransaction();
		session.persist(student);
		session.getTransaction().commit();
	}
}

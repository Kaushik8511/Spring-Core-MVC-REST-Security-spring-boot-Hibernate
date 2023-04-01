package com.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class CreateStudent {
	public static void main(String[] args) {
		
		SessionFactory factory = null;
		try {
			factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
			Session session = factory.getCurrentSession();
			
			//begin the transaction
			session.beginTransaction();
			
			Student student = new Student("kaushik", "Prajapati", "new_email.com");
			
			session.save(student);
			
			session.getTransaction().commit();
		}
		finally {
			if(factory != null) factory.close();
		}
		
	}

}
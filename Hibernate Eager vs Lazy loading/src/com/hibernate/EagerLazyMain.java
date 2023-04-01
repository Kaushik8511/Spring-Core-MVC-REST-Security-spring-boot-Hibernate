package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class EagerLazyMain {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		Session session = null;
		
		
		try {
			factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
			session = factory.getCurrentSession();
			
			
			//begin transaction
			session.beginTransaction();
			
			//get the instructor
			Instructor instructor = session.get(Instructor.class, 4);
			
			System.out.println("My application Instructor: " + instructor);
			
			//SOLUTION - 1
			//call getters for the dependent entities which we want to load while session is open
			System.out.println(instructor.getCourses());
			
			session.getTransaction().commit();
			if(session != null) session.close();
			
			System.out.println("My application Courses: " + instructor.getCourses());
			
			//committing the transaction
			
			
		}
		finally {
			
			if(factory != null) factory.close();
		}
		
	}

}
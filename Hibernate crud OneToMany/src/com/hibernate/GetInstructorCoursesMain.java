package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class GetInstructorCoursesMain {

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
			
			System.out.println("Instructor: " + instructor);
			
			System.out.println("Courses: " + instructor.getCourses());
			
			//committing the transaction
			session.getTransaction().commit();
			
		}
		finally {
			if(session != null) session.close();
			if(factory != null) factory.close();
		}
		
	}

}
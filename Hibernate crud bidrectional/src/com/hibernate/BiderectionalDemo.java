package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class BiderectionalDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		Session session = null;
		
		
		try {
			factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.buildSessionFactory();
			session = factory.getCurrentSession();
			
			//starting the transaction
			session.beginTransaction();
			
			//get the instructor details
			InstructorDetails instructorDetails = session.get(InstructorDetails.class, 222);
			
			
			//print it
			System.out.println(instructorDetails);
			
			
			//get the instructor associated with it
			Instructor instructor = instructorDetails.getInstructor();
			
			System.out.println(instructor);
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			if(session != null) session.close();
			if(factory != null) factory.close();
		}
		
	}

}

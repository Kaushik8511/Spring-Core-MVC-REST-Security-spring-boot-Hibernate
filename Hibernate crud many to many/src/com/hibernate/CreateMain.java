package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class CreateMain {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		
		
		try {
			factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.buildSessionFactory();
			Session session = factory.getCurrentSession();
			
			//create instructor object
			Instructor instructor = new Instructor("Kaushik", "Prajapati", "abc@gmail.com");
			
			//associate instructor details object
			instructor.setDetails(new InstructorDetails("http://youtube.com/kaushik8511", "writting"));
			
			session.beginTransaction();
			
			//saving the object
			//this will also save the instructor details object as we have given value of cascade to ALL in OneToOne mapping 
			//in the Instructor class
			System.out.println(session.save(instructor));
			
			session.getTransaction().commit();
			
		}
		finally {
			if(factory != null) factory.close();
		}
		
	}

}

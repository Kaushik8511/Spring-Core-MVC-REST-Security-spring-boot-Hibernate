package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;

public class DeleteMain {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		
		
		try {
			factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
			Session session = factory.getCurrentSession();
			
			
			session.beginTransaction();
			
			//get the instructor by id
			Instructor instructor = session.get(Instructor.class, 4);
			System.out.println(instructor);
			
			//delete the instructor
			if(instructor != null) {
				//it will also delete the instructorDetails object in the db
				//due to cascade option we set (ALL)
				session.delete(instructor);
			}
			
			//commit transaction
			session.getTransaction().commit();
			
		}
		finally {
			if(factory != null) factory.close();
		}
		
	}

}

package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class CreateCoursesMain {

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
			
			//get the instructor to the db
			Instructor instructor = session.get(Instructor.class, 4);
			
			//create the courses
			Course course1 = new Course("Complete stand up again");
			Course course2 = new Course("Complete Programming again");
			
			//add courses to the instructor
			instructor.add(course1);
			instructor.add(course2);
			
			//save it to database
			session.save(course1);
			session.save(course2);
			
			//committing the transaction
			session.getTransaction().commit();
			
		}
		finally {
			if(session != null) session.close();
			if(factory != null) factory.close();
		}
		
	}

}

package com.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;

public class FetchJoinLazyMain {

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
			
			//SOLUTION - 2
			//HQL join fetch
			Query<Instructor> query = session.createQuery("select i from Instructor i "
								+ "JOIN FETCH i.courses "
								+ "where i.id =:instructorId",
								Instructor.class);
			
			query.setParameter("instructorId", 4);
			
			Instructor instructor = query.getSingleResult();
			
			session.getTransaction().commit();
			if(session != null) session.close();
			
			System.out.println("My application Instructor: " + instructor);
			
			System.out.println("My application Courses: " + instructor.getCourses());
			
			//committing the transaction
			
			
		}
		finally {
			
			if(factory != null) factory.close();
		}
		
	}

}

package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;

public class CreateCourseAndReviewsMain {

	public static void main(String[] args) {
		
		SessionFactory factory = null;
		Session session = null;
		
		
		try {
			factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetails.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
			session = factory.getCurrentSession();
			 
			
			//begin transaction
			session.beginTransaction();
			
			//create course
			Course course = new Course("Looking for a title");
			
			//add some reviews
			course.addReview(new Review("Great course loved it"));
			course.addReview(new Review("Great course loved it again"));
			course.addReview(new Review("Not bad ha"));
			course.addReview(new Review("Can be improved"));
			
			//save the course... All the reviews also get saved by default
			session.save(course);
			
			System.out.println(course);
			System.out.println(course.getReviews());
			
			//committing the transaction
			session.getTransaction().commit();
			
		}
		finally {
			if(session != null) session.close();
			if(factory != null) factory.close();
		}
		
	}

}

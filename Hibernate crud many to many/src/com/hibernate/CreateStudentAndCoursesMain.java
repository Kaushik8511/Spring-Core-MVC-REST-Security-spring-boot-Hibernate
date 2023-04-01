package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class CreateStudentAndCoursesMain {

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
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
			session = factory.getCurrentSession();
			 
			
			//begin transaction
			session.beginTransaction();
			
			//create course
			Student student = session.get(Student.class, 1);
			
			
			Course course1 = session.get(Course.class, 2);
			Course course2 = session.get(Course.class, 3);
			Course course3 = session.get(Course.class, 4);
			
			student.addCourse(course1);
			student.addCourse(course2);
			student.addCourse(course3);
			
			
			session.save(student);
			
			
			//committing the transaction
			session.getTransaction().commit();
			
		}
		finally {
			if(session != null) session.close();
			if(factory != null) factory.close();
		}
		
	}

}

package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class CreateCourseAndStudentsMain {

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
			Course course = new Course("Looking for a title");
			
			session.save(course);
			
			Student student1 = session.get(Student.class, 1);
			Student student2 = new Student("Ravi", "Patel", "NoEmail.com");
			Student student3 = new Student("Avi", "Patel", "again_no_email.com");
			
			course.addStudent(student1);
			course.addStudent(student2);
			course.addStudent(student3);
			
			//saving the students
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			
			System.out.println(course);
			System.out.println(course.getStudents());
			
			
			//committing the transaction
			session.getTransaction().commit();
			
		}
		finally {
			if(session != null) session.close();
			if(factory != null) factory.close();
		}
		
	}

}

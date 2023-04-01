package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	private List<Student> students;

	@PostConstruct
	public void initializeStudentsList() {
		students = new ArrayList<Student>();

		students.add(new Student("Kaushik", "Prajapati"));
		students.add(new Student("Jeet", "Dhanesha"));
	}

	// serve list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return students;
	}

	// serve student by id
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		if (students.size() <= studentId || studentId < 0)
			throw new StudentNotFoundException("student not found");
		return students.get(studentId);
	}

}

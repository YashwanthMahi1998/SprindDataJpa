package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Test
	public void printCourses() {
		List<Course>courses =courseRepository.findAll();
		System.out.println("Courses:"+courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher=Teacher
				.builder()
				.firstName("Parasu")
				.lastName("Ram")
				.build();
		Student student=Student
				.builder()
				.firstName("Rama")
				.lastName("Rao")
				.emailId("ramarao.12@gmail.com")
				.build();
		
		Course course=Course
				.builder()
				.title("AI")
				.credit(9)
				.teacher(teacher)
				.build();
		course.addStudent(student);
		courseRepository.save(course);
	}
	

}

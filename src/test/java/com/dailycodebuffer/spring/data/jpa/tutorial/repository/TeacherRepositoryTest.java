package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {
	@Autowired
	private TeacherRepository teacherRepository;

	@Test
	public void saveTeacher() {
		Course course=Course
				.builder()
				.title("DB")
				.credit(6)
				.build();
		Course course1=Course
				.builder()
				.title("Java")
				.credit(6)
				.build();
				
		Teacher teacher=Teacher
				.builder()
				.firstName("Yashwanth")
				.lastName("Maheswara")
				//.courses(List.of(course1))
				.build();
		teacherRepository.save(teacher);
	}
	

}

package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	/*
	 * @Test public void saveStudent() { Student student=Student.builder()
	 * .emailId("yash.rock@gmail.com") .firstName("Bhanu") .lastName("Yashwanth")
	 * .guardianName("NagaRaju") .guardianEmail("nag.12@gmail.com")
	 * .guardianMobile("9398261077") .build(); studentRepository.save(student); }
	 */
	/*
	 * @Test public void saveStudentWithGuardian() { Guardian
	 * guardian=Guardian.builder() .name("Shyam") .email("Shyam.12@gmail.com")
	 * .build(); Student student=Student.builder() .firstName("Leon")
	 * .lastName("Kennedy") .emailId("leon.ken@gmail.com") .guardian(guardian)
	 * .build(); studentRepository.save(student); }
	 */
	@Test
	public void printAllStudents() {
		List<Student>students=studentRepository.findAll();
		System.out.println("Students List:"+students);
	}
	@Test
	public void printAllStudentsByFirstName() {
		List<Student>students=studentRepository.findByFirstName("Bhanu");
		System.out.println("Students List by First Name:"+students);
	}
	@Test
	public void printAllStudentsByFirstNameContaining() {
		List<Student>students=studentRepository.findByFirstNameContaining("n");
		System.out.println("Students List by FirstNameContaining:"+students);
	}
	@Test
	public void printAllStudentsBylastName() {
		List<Student>students=studentRepository.findByLastName("Kennedy");
		System.out.println("Students List by Last Name:"+students);
	}
	@Test
	public void printAllStudentsByGuardianName() {
		List<Student>students=studentRepository.findByGuardianName("NagaRaju");
		System.out.println("Students List by GuardianName:"+students);
	}
	@Test
	public void printStudentByEmailAddress() {
		Student student=studentRepository.getStudentByEmailAddress("yash.rock@gmail.com");
		System.out.println("printStudentByEmailAddress:"+student);
	}
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String student=studentRepository.getStudentFirstNameByEmailAddress("leon.ken@gmail.com");
		System.out.println("printStudentFirstNameByEmailAddress:"+student);
	}
	@Test
	public void printStudentByEmailAddressNative() {
		Student student=studentRepository.getStudentByEmailAddressNative("yash.rock@gmail.com");
		System.out.println("getStudentByEmailAddressNative:"+student);
	}
	@Test
	public void updateStudentNameByEmailAddressNative() {
		studentRepository.updateStudentNameByEmailId("Leon","leon.ken@gmail.com");
		//System.out.println("updateStudentNameByEmailAddressNative:"+student);
	}
}

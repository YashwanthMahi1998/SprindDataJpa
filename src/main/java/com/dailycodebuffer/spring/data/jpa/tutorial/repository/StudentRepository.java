package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	List<Student>findByFirstName(String firstName);
	List<Student>findByLastName(String lastName);
	List<Student>findByFirstNameContaining(String name);
	List<Student>findByGuardianName(String guardianName);
	
	@Query("Select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String emailaddress);
	
	@Query("Select s.firstName from Student s where s.emailId=?1")
	String getStudentFirstNameByEmailAddress(String emailaddress);
	
	@Query(value="select * from tbl_student s where s.email_address=?1",nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailaddress);
	
	
	@Transactional
	@Modifying
	@Query(value = "update tbl_student  set  first_name=?1 where email_address=?2",nativeQuery = true)
	int updateStudentNameByEmailId(String firstName,String email);

}

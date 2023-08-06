package com.nitish.CRUDHibernate;

import com.nitish.CRUDHibernate.dao.StudentDAO;
import com.nitish.CRUDHibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studetDAO);                // For Saving single Student
			createMultipleStudents(studentDAO);       // For Saving Multiple Student
			//readStudent(studentDAO);                  // For Retreving Single  Student
			//queryForStudents(studentDAO);                // For Retreving All  Student
			//queryForStudentsByLastName(studentDAO);      //
			//queryForUpdate(studentDAO);
			//deleteStudent(studentDAO);
			  //deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int deletedRecords = studentDAO.deleteAll();
		System.out.println("Total number of Records deleted: " + deletedRecords);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 6;
		System.out.println("Deleting student with id : " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Records after delete");

		queryForStudents(studentDAO);

	}

	private void queryForUpdate(StudentDAO studentDAO) {
		// retrive the student based on id
		System.out.println("Retreving the student with id : 1");
		Student myStudent = studentDAO.findById(1);
		System.out.println(myStudent);

		// change the mail id
		myStudent.setEmail("nitishthakur346@gmail.com");
		System.out.println("Updating record in database...");

		// update the record
		studentDAO.updateStudent(myStudent);
		System.out.println("Record updated successfully in database...");

		// Show the Updated record
		myStudent = studentDAO.findById(1);
		System.out.println("Updated record information...");
		System.out.println(myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> Stud = studentDAO.findByLastName("thakur");

		for (Student tempStudent : Stud) {
			System.out.println(tempStudent);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
		Student myStudent = studentDAO.findById(1);
		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// Create the student object
		System.out.println("Creating Multiple students object.....");
		Student tempStudent1 = new Student("Jacob", "Ramsey", "jacobramsey@gmail.com");
		Student tempStudent2 = new Student("Jackson", "Smith", "jacksonsmith@gmail.com");
		Student tempStudent3 = new Student("Tim", "David", "timdavid@gmail.com");
		Student tempStudent4 = new Student("David", "warner", "davidwarner@gmail.com");
		Student tempStudent5 = new Student("Andy", "Robertson", "andyrob@gmail.com");

		// Save the student object
		System.out.println("Saving  Multiple students to Database.....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent5);

	}

	private void createStudent(StudentDAO studetDAO) {

		// Create the student object
		System.out.println("Creating new student object.....");
		Student tempStudent = new Student("nitish", "Thakur", "nitishthakur92@gmail.com");

		// Save the student object
		System.out.println("Saving  student to Database.....");
		studetDAO.save(tempStudent);

		// Display id of the save object

		System.out.println("Student Saved to database successfully. With generated id: " + tempStudent.getId());
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}


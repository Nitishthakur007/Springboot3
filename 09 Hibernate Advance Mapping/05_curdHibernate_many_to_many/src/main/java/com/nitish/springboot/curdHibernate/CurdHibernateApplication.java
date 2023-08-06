package com.nitish.springboot.curdHibernate;

import com.nitish.springboot.curdHibernate.DAO.AppDAO;
import com.nitish.springboot.curdHibernate.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurdHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createCourseAndStudents(appDAO);
			//findCourseAndStudent(appDAO);
			//findStudentAndCourse(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourseById(appDAO);
			deleteStudentById(appDAO);
			
		};

	}

	private void deleteStudentById(AppDAO appDAO) {

		int theId = 8;
		System.out.println("Deleting Course with id: " + theId);

		appDAO.deleteStudentById(theId);

		System.out.println("Deleted record successfully!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);

		// create more courses
		Course tempCourse1 = new Course("Atari 2600- Game Development");
		Course tempCourse2 = new Course("Data Analyst - Data Analysing skills");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);


		System.out.println("Updating Student : " + tempStudent);
		System.out.println("Associated course: " + tempStudent.getCourses());

		appDAO.update(tempStudent);

		System.out.println("Done");



	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId = 5;

		//find the Student
		System.out.println("Finding Student id: " + theId);

		Student tempStudent = appDAO.findStudentAndCourseByStudentId(theId);
		System.out.println("Student Details: " + tempStudent);

		System.out.println("Associated  course Details: " + tempStudent.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int theId = 10;

		//find the Course
		System.out.println("Finding Course id: " + theId);

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);
		System.out.println("Course Details: " + tempCourse);

		System.out.println("Associated enrolled Students Details: " + tempCourse.getStudents());
		System.out.println("Done!");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		/*// create a course
		Course tempCourse = new Course("Java - Java Masterclass from zero to hero");
		// create the Students
		Student tempStudent1 = new Student("Nitish","Thakur","nitishthakur@gmail.com");
		Student tempStudent2 = new Student("Mary","smith","smithmary@gmail.com");
		Student tempStudent3 = new Student("collin","shunaka","colinshunaka@gmail.com");
		Student tempStudent4 = new Student("james","simpson","jamessimpson@gmail.com");
		Student tempStudent5 = new Student("richard","frank","richardfrank@gmail.com");*/



		// create a course
		Course tempCourse = new Course("Python programming - Python Masterclass from zero to hero");
		// create the Students
		Student tempStudent1 = new Student("Nitish","Thakur","nitishthakur@gmail.com");
		Student tempStudent2 = new Student("Mary","smith","smithmary@gmail.com");
		Student tempStudent3 = new Student("collin","shunaka","colinshunaka@gmail.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		tempCourse.addStudent(tempStudent3);
		/*tempCourse.addStudent(tempStudent4);
		tempCourse.addStudent(tempStudent5);*/

		// save the course and associated students
		System.out.println("Saving Course : " + tempCourse);
		System.out.println("Saving associated students " + tempCourse.getStudents());

		appDAO.save(tempCourse);

		System.out.println("Records saved successfully!.........");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;
		System.out.println("Deleting Course with id: " + theId);
		appDAO.deleteCourseById(theId);
		System.out.println(" Record deleted successfully!...");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		//find the Course
		System.out.println("Finding Course id: " + theId);

		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println("Course Details: " + tempCourse);

		System.out.println("Associated Reviews Details: " + tempCourse.getReviews());
		System.out.println("Done!");



	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse = new Course("Playing Guitar- Everything you need to learn");

		// add some reviews
		tempCourse.addReview(new Review("Great Course ... job well done"));
		tempCourse.addReview(new Review("Covers Everything ... love the course"));
		tempCourse.addReview(new Review("Not much helpful ... only for beginners level"));

		// save the course.. and leverage the cascade all
		System.out.println("Saving Course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);

		System.out.println("Records saved successfully");
	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId = 11;
		System.out.println("Deleting Course with id: " + theId);

		appDAO.deleteCourseById(theId);

		System.out.println("Deleted record successfully!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 11;
		//find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: " + theId);
		tempCourse.setTitle("Python from zero to hero");
		appDAO.update(tempCourse);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		//find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instructor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);
		System.out.println("Done!");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		//find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("Instructor Details: " + tempInstructor);

		System.out.println("Associated courses Details: " + tempInstructor.getCourses());
		System.out.println("Done!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor Details: " + tempInstructor);

		// find Courses for Instructor
		System.out.println("find Courses for Instructor: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the object
		tempInstructor.setCourses(courses);

		System.out.println("courses Details: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor Details: " + tempInstructor);
		System.out.println("Associate instructorDetails: " + tempInstructor.getInstructorDetail());
		System.out.println("Associate courses Details: " + tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void crteateInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor theInstructor = new Instructor("Nitish","Thakur","thakurnitish@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.codewithNitish.com/youtube",
				"love to teach code");


        // associate the objects
		theInstructor.setInstructorDetail(tempInstructorDetail);

		//create courses
		Course tempCourses = new Course("Java Masterclass");
		Course tempCourses2 = new Course("Python Masterclass");
		Course tempCourses3 = new Course("Data Structure using Java");
		Course tempCourses4 = new Course("MYSQL Masterclass");

		// add courses to instructor
		theInstructor.add(tempCourses);
		theInstructor.add(tempCourses2);
		theInstructor.add(tempCourses3);
		theInstructor.add(tempCourses4);



		//  save the instructor
		//
		// Note: this will also save the details object
		// because of cascadeType.ALL
		// Note: this will also save the courses
		// because of cascadeType.PERSIST

		System.out.println("Saving instructor: " + theInstructor);
		System.out.println("The courses: " + theInstructor.getCourses());
		appDAO.save(theInstructor);

		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Deleting instructorDetail with id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Deleted record successfully!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructorDetail with id: " + theId);
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("InstructorDetail: " + tempInstructorDetail);
		System.out.println("Associate instructor Details: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor with id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Deleted record successfully!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("Instructor Details: " + tempInstructor);
		System.out.println("Associate instructorDetails: " + tempInstructor.getInstructorDetail());
		System.out.println("Done!");
	}

	private void createInstructor(AppDAO appDAO) {

		// create the instructor
		Instructor theInstructor = new Instructor("Harry","Singh","Harry@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.codewithHarry.com/youtube",
				"love to teach code");


		/*// create the instructor
		Instructor theInstructor = new Instructor("Nitish","Thakur","nitishthakur@gmail.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.cyberSec.com/youtube",
				"love to learn");*/

		// associate the objects
		theInstructor.setInstructorDetail(tempInstructorDetail);

		//  save the instructor
		//
		// Note: this will also save the details object
		// because of cascadeType.ALL
		//

		System.out.println("Saving instructor: " + theInstructor);
		appDAO.save(theInstructor);
	}

}

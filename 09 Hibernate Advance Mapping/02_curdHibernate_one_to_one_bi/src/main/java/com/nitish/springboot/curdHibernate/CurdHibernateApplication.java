package com.nitish.springboot.curdHibernate;

import com.nitish.springboot.curdHibernate.DAO.AppDAO;
import com.nitish.springboot.curdHibernate.entity.Instructor;
import com.nitish.springboot.curdHibernate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurdHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			deleteInstructorDetail(appDAO);
		};

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

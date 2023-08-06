package com.nitish.springAOP;

import com.nitish.springAOP.DAO.AccountDAO;
import com.nitish.springAOP.DAO.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		// call the business method

		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true);
 		theAccountDAO.doWork();
		// call the membership business method
		theMembershipDAO.addAccount();


		// call the membership business method which return boolean output

		theMembershipDAO.addAccount1();
	}

}

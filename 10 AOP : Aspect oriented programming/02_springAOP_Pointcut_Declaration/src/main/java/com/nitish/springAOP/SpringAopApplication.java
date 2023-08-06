package com.nitish.springAOP;

import com.nitish.springAOP.DAO.AccountDAO;
import com.nitish.springAOP.DAO.MembershipDAO;
import com.nitish.springAOP.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO, TrafficFortuneService trafficFortuneService){
		return runner -> {
			//demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(trafficFortuneService);
			//demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortunate()");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\nMy Fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortunate()");
		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);
		System.out.println("\nMy Fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortunate()");
		String data = trafficFortuneService.getFortune();
		System.out.println("\nMy Fortune is: " + data);
		System.out.println("Finished");

	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// call the business method
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire= false;
			theAccounts= theAccountDAO.findAccounts(tripWire);

		} catch (Exception exc){
			System.out.println("\n\nMain Program: caught exception: " + exc);
		}
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("--------");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

		// call the business method
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire= true;
			theAccounts= theAccountDAO.findAccounts(tripWire);

		} catch (Exception exc){
			System.out.println("\n\nMain Program: caught exception: " + exc);
		}
		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterThrowingAdvice");
		System.out.println("--------");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call the business method
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println("--------");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("James foster");
		myAccount.setLevel("Gold");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.addBalancetoAccount(1000,true);
 		theAccountDAO.doWork();

		 // call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("gold");
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();


		// call the membership business method
		theMembershipDAO.addAccount();


		// call the membership business method which return boolean output

		theMembershipDAO.addAccount1();
	}

}

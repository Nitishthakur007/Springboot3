package com.nitish.springAOP.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with @Before advice


    // Matching on all addAccount()
   /* @Before("execution(public void addAccount())")
   // @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }*/



    // Matching on only AccoountDAO addAccount()
   /* @Before("execution(public void com.nitish.springAOP.DAO.AccountDAO.addAccount())")
    // @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }*/


    // Matching method starting with "add" in any class using pointcut expression and using wildcards
  /*  @Before("execution(public void add*())")
    // @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }*/


    // Matching method with based on return type using pointcut expression
    /*@Before("execution(* add*())")
    // @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }*/



  /*  @Before("execution(* add*(com.nitish.springAOP.Account))")
    // @Before("execution(public void updateAccount())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }*/

  /*  @Before("execution(* add*(com.nitish.springAOP.Account,..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }*/


    // Match method with any pattern
    /*@Before("execution(* add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }*/



    // Match method in a package
    @Before("execution(* com.nitish.springAOP.DAO.*.*())")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }
}

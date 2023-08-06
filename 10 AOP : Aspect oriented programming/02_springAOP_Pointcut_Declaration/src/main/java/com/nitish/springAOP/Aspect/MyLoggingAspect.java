package com.nitish.springAOP.Aspect;


import com.nitish.springAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {


  /*  @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n =====> Executing @Before advice on addAccount()");
    }
    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n =====> Performing API analytics operations");
    }
*/

    @Around("execution(* com.nitish.springAOP.Service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceddingJoinPoint) throws Throwable{

        // print out which method we are advising on
        String method = theProceddingJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @Around on method: " + method);

        // get beginning timestamp
        long begin = System.currentTimeMillis();

        // now let's execute the method
        Object result = null;
        try {
            result = theProceddingJoinPoint.proceed();
        }catch (Exception exc){
            // log the exception
            System.out.println(exc.getMessage());


            // give user a custom message
           /* result = "Major accident! Highway is closed please avoid route";*/

            //rethrow exception
            throw exc;


        }


        // get end timestamp
        long end = System.currentTimeMillis();
        //compute duration and display it
        long duration = begin - end;
        System.out.println("\n====> Duration: " + duration);
        return result;
    }

    @After("execution(* com.nitish.springAOP.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @After(Finally) on method: " + method);
    }


    @AfterThrowing(
            pointcut = "execution(* com.nitish.springAOP.DAO.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
            JoinPoint theJoinPoint,Throwable theExc){
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n====> Execption is: " + theExc);


    }





    // add a new advice for @AfterReturning on findAccounts method
    @AfterReturning(
            pointcut  = "execution(* com.nitish.springAOP.DAO.AccountDAO.findAccounts(..))",
            returning="result")
        public void afterReturningFindAccountsAdvice(JoinPoint theJointPoint, List<Account> result){

        // print out which method we are advising on
        String method = theJointPoint.getSignature().toShortString();
        System.out.println("\n====> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n====> Result is: " + result);

        // let's post-process the data ... let's modify it :-)
        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop the accounts
        for(Account tempAccount:result){

            // get uppercase version of name
            String theUpperCase = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperCase);

        }


    }


    @Before("com.nitish.springAOP.Aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("=====> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        // display method arguments
        // get Args
        Object[] args = theJoinPoint.getArgs();

        // loop through args
        for(Object tempArgs: args){
            System.out.println(tempArgs);

            if(tempArgs instanceof Account){
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArgs;

                System.out.println("Account Name : "+ theAccount.getName());
                System.out.println("Account level : "+ theAccount.getLevel());
            }
        }
    }
}

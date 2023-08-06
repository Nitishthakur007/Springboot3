package com.nitish.springboot.MVC_CRUD.Aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration
    @Pointcut("execution(* com.nitish.springboot.MVC_CRUD.Controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.nitish.springboot.MVC_CRUD.Service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.nitish.springboot.MVC_CRUD.DAO.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        // display method we are calling
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> in @Before: calling method: " + theMethod);

        // display the arguments to the method
        //get the arguments
        Object[] args = theJoinPoint.getArgs();
        // loop thru and display args
        for(Object tempArgs : args){
            myLogger.info("====> arguments: " + tempArgs);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint theJoinPoint,Object theResult){

        // display method we are returning from
        String theMethod = theJoinPoint.getSignature().toShortString();
        myLogger.info("====> in @AfterReturning: calling method: " + theMethod);

        // display data returned
        myLogger.info("====> arguments: " + theResult);

    }
}

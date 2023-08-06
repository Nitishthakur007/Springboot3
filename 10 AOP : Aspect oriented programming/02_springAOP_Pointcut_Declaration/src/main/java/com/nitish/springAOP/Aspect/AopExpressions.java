package com.nitish.springAOP.Aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.nitish.springAOP.DAO.*.*(..))")
    public void forDaoPackage(){}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.nitish.springAOP.DAO.*.get*(..))")
    public void getter(){}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.nitish.springAOP.DAO.*.set*(..))")
    public void setter(){}

    // create a pointcut to include package.. exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter(){}

}

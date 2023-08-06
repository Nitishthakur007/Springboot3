package com.nitish.springAOP.DAO;


import com.nitish.springAOP.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{


    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);

    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for Academic purpose...
        if(tripWire){
            throw new RuntimeException("No soup for you!!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account("John","silver");
        Account temp2 = new Account("James","gold");
        Account temp3 = new Account("Eric","platinum");
        Account temp4 = new Account("Stuart","silver");
        Account temp5 = new Account("Andrew","gold");


        // add them to our accounts list
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        myAccounts.add(temp4);
        myAccounts.add(temp5);

        return myAccounts;    }

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "Inside AccountDAOImpl class and doWork() method");
        return true;
    }

    @Override
    public void addBalancetoAccount(int balance, boolean vipFlag) {
        System.out.println(getClass() + "Adding balance to account");
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}

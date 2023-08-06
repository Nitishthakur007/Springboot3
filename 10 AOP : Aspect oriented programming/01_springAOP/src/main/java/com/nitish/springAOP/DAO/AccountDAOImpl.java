package com.nitish.springAOP.DAO;


import com.nitish.springAOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "Inside AccountDAOImpl class and doWork() method");
        return true;
    }
}

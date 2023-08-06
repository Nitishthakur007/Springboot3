package com.nitish.springAOP.DAO;

import com.nitish.springAOP.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}

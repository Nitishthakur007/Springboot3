package com.nitish.springAOP.DAO;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }

    @Override
    public boolean addAccount1() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT IN BOOLEAN RETURNING FUNCTION");
        return true;
    }
}

package com.nitish.springboot.RESTCRUD.DAO;

import com.nitish.springboot.RESTCRUD.Model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // Define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }


    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        // execute query and get result list
        List<Employee> empList = theQuery.getResultList();
        // return list
        return empList;
    }

    @Override
    public Employee findById(String empId) {
        Employee theEmployee = entityManager.find(Employee.class,empId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(String empId) {
        Employee dbEmployee = entityManager.find(Employee.class,empId);
        entityManager.remove(dbEmployee);
    }
}

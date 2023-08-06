package com.nitish.springboot.RESTCRUD.DAO;

import com.nitish.springboot.RESTCRUD.Model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee>findAll();

    Employee findById(String empId);

    Employee save(Employee theEmployee);

    void deleteById(String empId);
}

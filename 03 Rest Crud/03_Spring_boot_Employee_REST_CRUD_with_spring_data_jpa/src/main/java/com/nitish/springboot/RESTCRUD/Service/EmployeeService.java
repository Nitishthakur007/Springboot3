package com.nitish.springboot.RESTCRUD.Service;

import com.nitish.springboot.RESTCRUD.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();


    Employee findById(String empId);

    Employee save(Employee theEmployee);

    void deleteById(String empId);
}

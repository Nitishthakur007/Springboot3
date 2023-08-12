package com.nitish.springboot.MVC_CRUD.Service;

import com.nitish.springboot.MVC_CRUD.Model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();


    Employee findById(String empId);

    Employee save(Employee theEmployee);

    void deleteById(String empId);
}

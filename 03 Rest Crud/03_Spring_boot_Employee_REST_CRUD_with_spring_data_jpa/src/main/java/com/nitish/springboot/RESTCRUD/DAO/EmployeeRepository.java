package com.nitish.springboot.RESTCRUD.DAO;

import com.nitish.springboot.RESTCRUD.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}

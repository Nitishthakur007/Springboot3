package com.nitish.springboot.MVC_CRUD.DAO;

import com.nitish.springboot.MVC_CRUD.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {

}

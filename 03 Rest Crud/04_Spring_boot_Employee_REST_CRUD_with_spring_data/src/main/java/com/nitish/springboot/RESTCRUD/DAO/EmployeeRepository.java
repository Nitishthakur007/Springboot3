package com.nitish.springboot.RESTCRUD.DAO;

import com.nitish.springboot.RESTCRUD.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee,String> {
}

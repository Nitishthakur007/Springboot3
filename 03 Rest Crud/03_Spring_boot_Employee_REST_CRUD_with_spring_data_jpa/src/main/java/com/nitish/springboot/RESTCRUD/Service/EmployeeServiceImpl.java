package com.nitish.springboot.RESTCRUD.Service;

import com.nitish.springboot.RESTCRUD.DAO.EmployeeRepository;
import com.nitish.springboot.RESTCRUD.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo){
        employeeRepo = theEmployeeRepo;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(String empId) {
        Optional<Employee> result = employeeRepo.findById(empId);
        Employee theEmployee = null;

        if(result.isPresent()){
            theEmployee = result.get();
        }else {
            throw new RuntimeException("Did not find employee id - "+empId);
        }
        return theEmployee;
    }


    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepo.save(theEmployee);
    }


    @Override
    public void deleteById(String empId) {
        employeeRepo.deleteById(empId);

    }


}

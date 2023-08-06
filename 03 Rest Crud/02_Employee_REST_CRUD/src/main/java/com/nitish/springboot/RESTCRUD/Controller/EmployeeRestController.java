package com.nitish.springboot.RESTCRUD.Controller;

import com.nitish.springboot.RESTCRUD.DAO.EmployeeDAO;
import com.nitish.springboot.RESTCRUD.Model.Employee;
import com.nitish.springboot.RESTCRUD.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    //  expose "/employees" and return a list of employees
    @GetMapping("/employees")
        public List<Employee> getAllEmp(){
         return employeeService.findAll();
        }

    @GetMapping("/employees/{empId}")
    public Employee getEmpById(@PathVariable String empId) {
        Employee theEmployee = employeeService.findById(empId);
        if(theEmployee.equals(null)) {
            throw new RuntimeException();
        }
        return theEmployee;
    }


    @PostMapping("/employees")
    public Employee addEmp(@RequestBody Employee theEmployee) {
        Employee dbEmployee;
        // check whether the passed empid is already in database or not - to avoid update by mistake
        Employee tempEmp = employeeService.findById(theEmployee.getEmpId());
        if(tempEmp == null){
            dbEmployee = employeeService.save(theEmployee);
        }else {
            throw new RuntimeException("Employee Id is already present in system " + tempEmp.getEmpId());
        }
       return dbEmployee;
    }



    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return theEmployee;
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmpById(@PathVariable String empId) {
        Employee tempEmployee = employeeService.findById(empId);
        if(tempEmployee == null) {
            throw new RuntimeException("Employee id not found- " + empId);
        }
        employeeService.deleteById(empId);
        return "Deleted Employee id: " + empId;
    }

}
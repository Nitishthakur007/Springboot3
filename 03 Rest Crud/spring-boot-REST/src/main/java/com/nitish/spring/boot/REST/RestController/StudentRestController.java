package com.nitish.spring.boot.REST.RestController;

import com.nitish.spring.boot.REST.Model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    // define @PostConstruct to load the student data.... only once!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Nitish","Thakur"));
        theStudents.add(new Student("Marry","Smith"));
        theStudents.add(new Student("Mario","Rossi"));
        theStudents.add(new Student("David","Flower"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check the studentId against list size
        if((studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }


}
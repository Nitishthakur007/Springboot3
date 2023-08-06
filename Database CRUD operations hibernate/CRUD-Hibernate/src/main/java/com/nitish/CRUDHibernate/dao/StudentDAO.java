package com.nitish.CRUDHibernate.dao;

import com.nitish.CRUDHibernate.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student>findAll();


    List<Student>findByLastName(String lastName);


    void updateStudent(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}

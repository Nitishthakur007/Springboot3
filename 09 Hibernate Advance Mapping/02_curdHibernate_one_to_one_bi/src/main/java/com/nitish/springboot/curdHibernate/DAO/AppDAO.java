package com.nitish.springboot.curdHibernate.DAO;

import com.nitish.springboot.curdHibernate.entity.Instructor;
import com.nitish.springboot.curdHibernate.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);


    void deleteInstructorDetailById(int theId);
}

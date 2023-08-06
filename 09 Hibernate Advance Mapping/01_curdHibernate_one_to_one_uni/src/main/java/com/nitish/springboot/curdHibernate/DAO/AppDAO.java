package com.nitish.springboot.curdHibernate.DAO;

import com.nitish.springboot.curdHibernate.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}

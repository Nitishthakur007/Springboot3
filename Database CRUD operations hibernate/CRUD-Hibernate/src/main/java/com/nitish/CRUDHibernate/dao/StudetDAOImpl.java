package com.nitish.CRUDHibernate.dao;

import com.nitish.CRUDHibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudetDAOImpl implements StudentDAO{

    // Define field for entity manager
    EntityManager entityManager;

    // Inject entity manager using constructor Injection
@Autowired
    public StudetDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    // Implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName desc",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student where lastName=:theData",Student.class);
        theQuery.setParameter("theData",lastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudent(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
    Student theStudent = entityManager.find(Student.class,id);
    entityManager.remove(theStudent);


    }

    @Override
    @Transactional
    public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("Delete from Student").executeUpdate();
        return numRowsDeleted;
    }
}

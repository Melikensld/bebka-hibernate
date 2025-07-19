package com.melike.dao;

import com.melike.model.Student;
import com.melike.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student createStudent(Student student) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Student",Student.class).list();
        }
    }

    @Override
    public Student getStudentById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Student.class,id);
        }
    }

    @Override
    public void updateStudent(Student student) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        }catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }e.printStackTrace();
        }
    }
}

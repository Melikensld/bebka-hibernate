package com.melike.dao;

import com.melike.model.Student;
import com.melike.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}

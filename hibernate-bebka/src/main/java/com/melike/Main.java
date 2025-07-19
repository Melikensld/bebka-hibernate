package com.melike;

import com.melike.dao.StudentDao;
import com.melike.dao.StudentDaoImpl;
import com.melike.model.Student;
import com.melike.service.StudentService;
import com.melike.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = new Student("Melike", "Ünsaldı");
            session.save(student);

            Student readStudent = session.get(Student.class, student.getId());
            System.out.println( "ID: " +readStudent.getId() + " name: "+readStudent.getName() + " surname: "+readStudent.getSurname());
            //readStudent.setName("ali");
            //session.save(readStudent);
            //session.delete(readStudent);

            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Transaction geri alındı. Hata:");
            e.printStackTrace();
        } finally {
            session.close();
        }
         */
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentService(studentDao);
        studentService.createStudent("Berkan", "Sevil");

    }
}
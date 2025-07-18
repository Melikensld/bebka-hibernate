package com.melike;

import com.melike.model.Student;
import com.melike.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = new Student("Ayse", "Aaa");
            session.save(student);

            Student readStudent = session.get(Student.class, student.getId());
            System.out.println(readStudent.getName());
            //readStudent.setName("ali");
            //session.save(readStudent);
            session.delete(readStudent);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
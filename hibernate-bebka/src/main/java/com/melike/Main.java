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
        StudentDao studentDao = new StudentDaoImpl();
        StudentService studentService = new StudentService(studentDao);

        //Create
        //studentService.createStudent("Berkan", "Sevil");

        //getAll
        /*
        for(Student student : studentService.getAllStudents()) {
            System.out.println(student.getId() + " - " + student.getName() + " " + student.getSurname());
        }
         */

        //getStudentById
        Student getStudentById = studentService.getStudentById(3);
        if(getStudentById != null) {
            System.out.println(getStudentById.getName() + " " + getStudentById.getSurname());
        }else {
            System.out.println("Student not found");
        }
    }
}
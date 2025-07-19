package com.melike.service;

import com.melike.dao.StudentDao;
import com.melike.model.Student;

public class StudentService {

    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student createStudent(String name, String surname) {
        if(name == null || surname == null) {
            return null;
        }
        Student student = new Student(name, surname);
        return studentDao.createStudent(student);
    }
}

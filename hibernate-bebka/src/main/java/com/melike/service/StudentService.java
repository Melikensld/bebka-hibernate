package com.melike.service;

import com.melike.dao.StudentDao;
import com.melike.model.Student;

import java.util.List;

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

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public void updateStudent(int id, String name, String surname) {
        Student student = studentDao.getStudentById(id);
        if(student != null) {
            student.setName(name);
            student.setSurname(surname);
            studentDao.updateStudent(student);
        }else  {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }
}

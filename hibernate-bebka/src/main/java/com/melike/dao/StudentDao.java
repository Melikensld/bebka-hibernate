package com.melike.dao;

import com.melike.model.Student;

import java.util.List;

public interface StudentDao {
    Student createStudent(Student student);
    List<Student> getAllStudents();
}

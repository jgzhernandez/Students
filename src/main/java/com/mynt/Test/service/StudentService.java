package com.mynt.Test.service;

import com.mynt.Test.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student saveStudent(Student student);
    String deleteStudent(Long id);
    Student updateStudent(Long id, Student student);
    List<Student> getStudentByAgeAndEmail(Integer age, String email);
}

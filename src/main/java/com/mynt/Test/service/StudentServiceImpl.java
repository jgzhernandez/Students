package com.mynt.Test.service;

import com.mynt.Test.model.Student;
import com.mynt.Test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).isPresent()? studentRepository.findById(id).get(): null;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "User deleted with ID: " + id;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).get();
        existingStudent.setId(student.getId());
        existingStudent.setAge(student.getAge());
        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());
        return studentRepository.save(existingStudent);
    }

    @Override
    public List<Student> getStudentByAgeAndEmail(Integer age, String email) {
        List<Student> studentsMatched = new ArrayList<>();
        studentRepository.findAll().forEach(student -> {
            if (student.getAge().equals(age) && student.getEmail().equals(email)){
                studentsMatched.add(student);
            }
        });
        return studentsMatched;
    }
}

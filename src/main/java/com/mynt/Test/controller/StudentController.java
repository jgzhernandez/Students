package com.mynt.Test.controller;

import com.mynt.Test.model.Student;
import com.mynt.Test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getStudentbyId(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudentbyId(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/student/{age}/{email}")
    public List<Student> getStudentByAgeAndEmail(@PathVariable Integer age, @PathVariable String email){
        return studentService.getStudentByAgeAndEmail(age, email);
    }

}

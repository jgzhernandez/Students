package com.mynt.Test.repository;

import com.mynt.Test.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long>{
    List<Student> findByAgeGreaterThan(int i);
    List<Student> findAllByOrderByAge();
    List<Student> findByNameIn(List<String> names);
}

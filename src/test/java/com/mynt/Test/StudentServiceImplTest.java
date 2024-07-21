package com.mynt.Test;

import com.mynt.Test.model.Student;
import com.mynt.Test.repository.StudentRepository;
import com.mynt.Test.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StudentServiceImplTest {
    Student mockStudent1;

    @Mock
    StudentRepository studentRepositoryMock;

    @InjectMocks
    StudentServiceImpl studentServiceImpl;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        mockStudent1 = new Student();
        mockStudent1.setId(1L);
        mockStudent1.setName("Jett");
        mockStudent1.setAge(24);
        mockStudent1.setEmail("jett@example.com");
    }

    @Test
    public void getAll(){
        ;
    }

    @Test
    public void getById(){
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.of(mockStudent1));
        assertEquals(mockStudent1,studentServiceImpl.getStudentById(1L));
    }

    @Test
    public void testSave(){
        when(studentRepositoryMock.save(any(Student.class))).thenReturn(new Student());
        assertNotNull(studentServiceImpl.saveStudent(new Student()));
    }

    @Test
    public void testDelete(){
        studentServiceImpl.deleteStudent(1L);
        verify(studentRepositoryMock).deleteById(1L);
    }

    @Test
    public void testUpdate(){
        ;
    }

    @Test
    public void testGetByAgeAndEmail(){
        ;
    }
}

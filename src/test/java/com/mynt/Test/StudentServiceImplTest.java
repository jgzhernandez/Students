package com.mynt.Test;

import com.mynt.Test.model.Student;
import com.mynt.Test.repository.StudentRepository;
import com.mynt.Test.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class StudentServiceImplTest {
    Student mockStudent1;
    Student mockStudent2;
    List<Student> sampleStudents;

    @Mock
    StudentRepository studentRepositoryMock;

    @InjectMocks
    StudentServiceImpl studentService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        mockStudent1 = new Student();
        mockStudent1.setId(1L);
        mockStudent1.setName("Jett");
        mockStudent1.setAge(24);
        mockStudent1.setEmail("jett@example.com");

        mockStudent2 = new Student();
        mockStudent2.setId(2L);
        mockStudent2.setName("Jimmy");
        mockStudent2.setAge(23);
        mockStudent2.setEmail("jimmy@example.com");
        sampleStudents = Arrays.asList(mockStudent1,mockStudent2);
    }

    @Test
    public void testGetAll(){
        when(studentRepositoryMock.findAll()).thenReturn(sampleStudents);
        List<Student> studentsOutputs = studentService.getAllStudent();

        assertEquals(2, studentsOutputs.size());
        assertEquals(sampleStudents, studentsOutputs);
        verify(studentRepositoryMock, times(1)).findAll();
    }

    @Test
    public void testGetById(){
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.of(mockStudent1));
        Student idOutput = studentService.getStudentById(1L);

        assertEquals(mockStudent1, idOutput);
        verify(studentRepositoryMock, times(2)).findById(1L);
    }

    @Test
    public void testSave(){
        when(studentRepositoryMock.save(any(Student.class))).thenReturn(new Student());

        assertNotNull(studentService.saveStudent(new Student()));
        verify(studentRepositoryMock, times(1)).save(any(Student.class));
    }

    @Test
    public void testDelete(){
        String deleteString = studentService.deleteStudent(1L);
        System.out.println(deleteString);

        assertEquals("User deleted with ID: 1", deleteString);
        verify(studentRepositoryMock).deleteById(anyLong());
    }

    @Test
    public void testUpdate(){
        when(studentRepositoryMock.findById(1L)).thenReturn(Optional.of(mockStudent1));
        when(studentRepositoryMock.save(any(Student.class))).thenReturn(mockStudent1);

        mockStudent1.setName("NewName");
        studentService.updateStudent(1L,mockStudent1);
        assertEquals("NewName",mockStudent1.getName());
        verify(studentRepositoryMock, times(1)).findById(anyLong());
        verify(studentRepositoryMock, times(1)).save(any(Student.class));
    }

    @Test
    public void testGetByAgeAndEmail(){
        when(studentRepositoryMock.findAll()).thenReturn(sampleStudents);
        List<Student> filteredStudents = studentService.getStudentByAgeAndEmail(24, "jett@example.com");

        assertEquals(1, filteredStudents.size());
        assertEquals("Jett", filteredStudents.get(0).getName());
        verify(studentRepositoryMock, times(1)).findAll();
    }
}

package com.mynt.Test;

import com.mynt.Test.model.Student;
import com.mynt.Test.repository.StudentRepository;
import com.mynt.Test.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentServiceImpl;

    @BeforeEach
    public void setup(){
        ;
    }

    @Test
    public void testSave(){
        StudentRepository rep = mock(StudentRepository.class);
        when(rep.save(any())).thenReturn(new Student());
        assertNotNull(rep.save(new Student()));
    }
}

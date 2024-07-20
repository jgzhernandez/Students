package com.mynt.Test.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity //mark class as entity
@Table //defining class name as Table name
public class Student {

    @Column //defining id as primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
//    private Long id;

    @Column
    public String name;
//    private String name;

    @Column
    public Integer age;
//    private Integer age;

    @Column
    public String email;
//    private String email;
}

package com.example.spring10ormtablecreation.entity;

import com.example.spring10ormtablecreation.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name= "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "studentFirstName")
    private String firstName; // In DB, first_name convection
    @Column(name= "studentLastName")
    private String lastName;
    private String email;

    @Transient
    private String city;

    @Column(columnDefinition = "DATE")
    private LocalDate birthDate;
    @Column(columnDefinition = "TIME")
    private LocalTime birthTime;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate birthDateTime;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}

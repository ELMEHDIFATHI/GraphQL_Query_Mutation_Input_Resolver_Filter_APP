package com.example.response;

import java.util.ArrayList;
import java.util.List;

import com.example.Entity.Student;
import com.example.Entity.Subject;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;


    private Student student;

    private  List<SubjectResponse> learningSubjects;

    private String fullName ;
    public StudentResponse (Student student) {
        this.student=student;
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();



    }

}

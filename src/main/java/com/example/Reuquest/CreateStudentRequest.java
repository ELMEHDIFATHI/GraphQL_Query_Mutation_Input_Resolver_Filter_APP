package com.example.Reuquest;

import com.example.response.SubjectResponse;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
@Getter
@Setter
public class CreateStudentRequest {


    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;


    private List<SubjectResponse> learningSubjects;
}

package com.example.query;


import com.example.Reuquest.SimpleRequest;
import com.example.Services.StudentServices;
import com.example.response.StudentResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {



    private StudentServices studentService;

    public String firstQuery(){
        return "FIRST QUERY";
    }

    public String secondQuery(){
        return "SECOND QUERY";
    }

    public String fullName (SimpleRequest simpleRequest) {
        return simpleRequest.getFirstName() + " " + simpleRequest.getLastName();
    }

    public StudentResponse student(int Id){
            return new StudentResponse(studentService.getStudentById(Id));
    }


}

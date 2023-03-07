package com.example.Mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.Reuquest.CreateStudentRequest;
import com.example.Services.StudentServices;
import com.example.response.StudentResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {


    public StudentServices studentServices;
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest){
            return new StudentResponse(studentServices.createStudent(createStudentRequest));
    }
}

package com.example.Resolver;


import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.Entity.Subject;
import com.example.Enumeration.SubjectNameFilter;
import com.example.response.StudentResponse;
import com.example.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> learningSubjects(StudentResponse studentResponse, SubjectNameFilter subjectNameFilter) {

        List<SubjectResponse> learningSubjects= new ArrayList<SubjectResponse>();


        if (studentResponse.getStudent().getLearningSubjects() != null ) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                if (subjectNameFilter.name().equals("ALL")) {
                     learningSubjects.add(new SubjectResponse(subject));   
                } else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName()))
                    learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }

    public String fullName(StudentResponse studentResponse){

        return studentResponse.getFirstName()+"======="+studentResponse.getLastName();

    }
}

package com.example.Services;

import com.example.Entity.Adresse;
import com.example.Entity.Student;
import com.example.Entity.Subject;
import com.example.Repository.AdresseRepo;
import com.example.Repository.StudentRepo;
import com.example.Repository.SubjectRepo;
import com.example.Reuquest.CreateStudentRequest;
import com.example.Reuquest.CreateSubjectRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServices {

    private final StudentRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final AdresseRepo adresseRepo;

    public Student getStudentById(int id) {
        return studentRepo.findById(id).get();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest);

        Adresse address = new Adresse();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        address = adresseRepo.save(address);

        student.setAddress(address);
        student = studentRepo.save(student);

        List<Subject> subjectsList = new ArrayList<>();

        if (createStudentRequest.getLearningSubjects() != null) {
            for (CreateSubjectRequest createSubjectRequest : createStudentRequest.getLearningSubjects()) {
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);

                subjectsList.add(subject);
            }

            subjectRepo.saveAll(subjectsList);
        }

        student.setLearningSubjects(subjectsList);

        return student;
    }
}

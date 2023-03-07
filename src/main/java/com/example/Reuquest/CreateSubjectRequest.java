package com.example.Reuquest;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class CreateSubjectRequest {
    private String subjectName;

    private Double marksObtained;
}

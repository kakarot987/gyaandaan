package com.student.Entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Subjects {

    @ApiModelProperty(notes = "Unique identifier of the Subject.",
            example = "1",required = true,position = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Name of the Subject.",
            example = "Maths",required = true,position = 1)
    @NotBlank
    @Column(name = "subjectName")
    private String subjectName;

    public Subjects(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}

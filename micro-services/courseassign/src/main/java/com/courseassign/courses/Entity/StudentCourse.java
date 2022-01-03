package com.courseassign.courses.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class StudentCourse {

    @Id
    private String id;

    private String className;

    private List<Subjects> subjects = new ArrayList<>();
}

//Data should be store in this document be like
/*
{
     "id" : "1"
     "class" : "x",
     "Subjects" : {
               "subjectName" : "Maths",
               "subjectName" : "Physics",
               "subjectName" : "Chemistry",
               "subjectName" : "Biology"
       }
}
 */
package com.courseassign.courses.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class SubjectSyllabus {

    @Id
    private String id;

    private String subject;

    private String className;

    private List<Syllabus> syllabus = new ArrayList<>();
}

//Data should be save in here as:
/*
{
   "id" : 1,
    "Subject" : "Maths",
    "Syllabus" : {
      "topicName" : "Trignometry",
      "topicName" : "Algerbra",
      "topicName" : "Geometry"
     }
}
 */
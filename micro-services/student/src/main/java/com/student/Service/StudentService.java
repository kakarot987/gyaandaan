package com.student.Service;

import com.student.Entity.Student;
import com.student.Entity.Subjects;
import com.student.Repository.StudentRepository;
import com.student.Request.AddStudentRequest;
import com.student.Response.AddStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Optional<AddStudentResponse> addStudent(AddStudentRequest addStudentRequest){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(formatter.format(date));
        System.out.println(date);

        Student student = new Student(
                addStudentRequest.getStudentName(),
                addStudentRequest.getStudentUsername(),
                addStudentRequest.getStudentMail(),
                addStudentRequest.getStudentDob(),
                addStudentRequest.getStudentPhone(),
                addStudentRequest.getStudentSchool(),
                addStudentRequest.getStudentClass(),
                addStudentRequest.getStudentCareerGoal(),
                addStudentRequest.getStudentBio(),
                0,
                date,
                "0%"
                );

        List<Subjects> subjects = new ArrayList<>();
        for (int i=0;i<addStudentRequest.getStudentSubjects().size();i++){
            subjects.add(
                    new Subjects(addStudentRequest.getStudentSubjects().get(i).getSubjectName())
            );
        }

        student.setStudentSubjects(subjects);
        Student stud = studentRepository.save(student);

        AddStudentResponse addStudentResponse = new AddStudentResponse(
                stud.getId(),
                stud.getStudentRegistrationDate()
        );

        return Optional.of(addStudentResponse);
    }

    public String updateProfile(AddStudentRequest addStudentRequest,Long id){
        Student student = new Student();

        List<Subjects> subjects = new ArrayList<>();
        for (int i=0;i<addStudentRequest.getStudentSubjects().size();i++){
            subjects.add(
                    new Subjects(addStudentRequest.getStudentSubjects().get(i).getSubjectName())
            );
        }

        studentRepository.updateStudentProfile(
                addStudentRequest.getStudentSchool(),
                addStudentRequest.getStudentCareerGoal(),
                addStudentRequest.getStudentBio(),
                id
        );
        return "changed";
    }


    private Date updateLoggedInDate(Long uuid){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(formatter.format(date));
        System.out.println(date);
        return date;
    }
}

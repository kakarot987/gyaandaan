package com.student.Entity;

import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@ApiModel(description = "Class representing a Student in the application")
@Entity
@Table(name="StudentInfo")
public class Student implements Serializable {

    private static final long serialVersionUID = 4048798961366546485L;

    @ApiModelProperty(notes = "Unique identifier of the Student.",
    example = "1",required = true,position = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "Name of the Student.",
    example = "Mayank Devrani",required = true,position = 1)
    @NotBlank
    @Column(name = "studentName")
    private String studentName;

    @ApiModelProperty(notes = "Username of the Student.",
            example = "xyz98766",required = true,position = 2)
    @Column(name = "studentUsername")
    private String studentUsername;

    @ApiModelProperty(notes = "Email address of the Student.",
            example = "mayank@devrani.com",required = true,position = 3)
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    @Size(max = 100)
    private String studentMail;

    @ApiModelProperty(notes = "Date of Birth of the Student.",
    example = "16/06/2000",required = true,position = 4)
    @NotBlank
    @Column(name = "studentDob")
    private Date studentDob;

    @ApiModelProperty(notes = "Mobile Number of the Student",
            example = "8118181818",required = true,position = 5)
    @Pattern(regexp = "\\+?[0-9. ()-]{10}",message = "Phone Number")
    @Size(max = 10)
    private String studentPhone;

    @ApiModelProperty(notes = "School of the Student",
    example = "XYZ Sr. Sec. School",required = false,position = 6)
    @Size(max = 100)
    @Column(name = "studentSchool")
    private String studentSchool;

    @ApiModelProperty(notes = "Class of the Student",
    example = "Class X", required = true,position = 7)
    @Size(max = 5)
    @Column(name = "studentClass")
    private String studentClass;

    @ApiModelProperty(notes = "Subject of the Student.",
    example = "Maths,Science,etc",required = false,position = 8)
    private String studentSubjects;

    @ApiModelProperty(notes = "Career goal of the Student.",
    example = "Doctor",required = false,position = 9)
    @Size(max = 100)
    @Column(name = "studentCareerGoal")
    private String studentCareerGoal;

    @ApiModelProperty(notes = "Short Bio of the Student.",
    example = "Hi, my name is xyz from class x.",required = false,position = 10)
    @Column(length = 4000)
    private String studentBio;


    @ApiModelProperty(notes = "Total number of courses a Student Register.",
            example = "5",required = true,position = 11)
    @Column(name = "studentTotalEnrollCourse")
    private int studentTotalEnroll;


    @ApiModelProperty(notes = "Registration Date of the Student.",
    example = "22/12/2021",required = true,position = 12)
    @Column(name = "studentRegistrationDate")
    private Date studentRegistrationDate;

    @ApiModelProperty(notes = "Last time Student logged in.",
    example = "22/12/2021",required = true,position = 13)
    @Column(name = "studentLastSeen")
    private Date studentLastSeen;

    @ApiModelProperty(notes = "Percentage of Profile Completion.",
    example = "90",required = true,position = 14)
    @Column(name = "studentProfileComplete")
    private int studentProfileComplete;

}

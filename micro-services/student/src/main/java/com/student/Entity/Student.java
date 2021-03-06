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
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "Class representing a Student in the application")
@Entity
@Table(name="StudentInfo")
public class Student implements Serializable {

    private static final long serialVersionUID = 4048798961366546485L;

    @ApiModelProperty(
            notes = "Unique identifier of the Student.",
            example = "1",
            required = true,
            position = 0
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long id;

    @ApiModelProperty(
            notes = "Name of the Student.",
            example = "Mayank Devrani",
            required = true,
            position = 1
    )
    @NotBlank
    @Column(name = "studentName")
    private String studentName;

    @ApiModelProperty(
            notes = "Username of the Student.",
            example = "xyz98766",
            required = true,
            position = 2
    )
    @Column(name = "studentUsername")
    private String studentUsername;

    @ApiModelProperty(
            notes = "Email address of the Student.",
            example = "mayank@devrani.com",
            required = true,
            position = 3
    )
    @Email(regexp=".*@.*\\..*", message = "Email should be valid")
    @Size(max = 100)
    private String studentMail;

    @ApiModelProperty(
            notes = "Date of Birth of the Student.",
            example = "16/06/2000",
            required = true,
            position = 4
    )
    @NotBlank
    @Column(name = "studentDob")
    private Date studentDob;

    @ApiModelProperty(
            notes = "Mobile Number of the Student",
            example = "8118181818",
            required = true,
            position = 5
    )
    @Pattern(regexp = "\\+?[0-9. ()-]{10}",message = "Phone Number")
    @Size(max = 10)
    private String studentPhone;

    @ApiModelProperty(
            notes = "School of the Student",
            example = "XYZ Sr. Sec. School",
            required = false,
            position = 6
    )
    @Size(max = 100)
    @Column(name = "studentSchool")
    private String studentSchool;

    @ApiModelProperty(
            notes = "Class of the Student",
            example = "Class X",
            required = true,
            position = 7
    )
    @Size(max = 5)
    @Column(name = "studentClass")
    private String studentClass;

    @ApiModelProperty(
            notes = "List of Subjects of the Student.",
            example = "Maths,Science,etc",
            required = false,
            position = 8
    )
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Subjects> studentSubjects = new ArrayList<>();

    @ApiModelProperty(
            notes = "Career goal of the Student.",
            example = "Doctor",
            required = false,
            position = 9
    )
    @Size(max = 100)
    @Column(name = "studentCareerGoal")
    private String studentCareerGoal;

    @ApiModelProperty(
            notes = "Short Bio of the Student.",
            example = "Hi, my name is xyz from class x.",
            required = false,
            position = 10
    )
    @Column(length = 4000)
    private String studentBio;

    @ApiModelProperty(
            notes = "Total number of courses a Student Register.",
            example = "5",
            required = true,
            position = 11
    )
    @Column(name = "studentTotalEnrollCourse")
    private int studentTotalEnroll;


    @ApiModelProperty(
            notes = "Registration Date of the Student.",
            example = "22/12/2021",
            required = true,
            position = 12
    )
    @Column(name = "studentRegistrationDate")
    private Date studentRegistrationDate;

    @ApiModelProperty(
            notes = "Last time Student logged in.",
            example = "22/12/2021",
            required = true,
            position = 13
    )
    @Column(name = "studentLastSeen")
    private Date studentLastSeen;

    @ApiModelProperty(
            notes = "Percentage of Profile Completion.",
            example = "90",
            required = true,
            position = 14
    )
    @Column(name = "studentProfileComplete")
    private String studentProfileComplete;

    public Student() {
    }

    public Student(String studentName, String studentUsername,
                   String studentMail, Date studentDob,
                   String studentPhone, String studentSchool,
                   String studentClass, String studentCareerGoal,
                   String studentBio, int studentTotalEnroll,
                   Date studentRegistrationDate, String studentProfileComplete) {
        this.studentName = studentName;
        this.studentUsername = studentUsername;
        this.studentMail = studentMail;
        this.studentDob = studentDob;
        this.studentPhone = studentPhone;
        this.studentSchool = studentSchool;
        this.studentClass = studentClass;
        this.studentCareerGoal = studentCareerGoal;
        this.studentBio = studentBio;
        this.studentTotalEnroll = studentTotalEnroll;
        this.studentRegistrationDate = studentRegistrationDate;
        this.studentProfileComplete = studentProfileComplete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentUsername() {
        return studentUsername;
    }

    public void setStudentUsername(String studentUsername) {
        this.studentUsername = studentUsername;
    }

    public String getStudentMail() {
        return studentMail;
    }

    public void setStudentMail(String studentMail) {
        this.studentMail = studentMail;
    }

    public Date getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(Date studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentSchool() {
        return studentSchool;
    }

    public void setStudentSchool(String studentSchool) {
        this.studentSchool = studentSchool;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public List<Subjects> getStudentSubjects() {
        return studentSubjects;
    }

    public void setStudentSubjects(List<Subjects> studentSubjects) {
        this.studentSubjects = studentSubjects;
    }

    public String getStudentCareerGoal() {
        return studentCareerGoal;
    }

    public void setStudentCareerGoal(String studentCareerGoal) {
        this.studentCareerGoal = studentCareerGoal;
    }

    public String getStudentBio() {
        return studentBio;
    }

    public void setStudentBio(String studentBio) {
        this.studentBio = studentBio;
    }

    public int getStudentTotalEnroll() {
        return studentTotalEnroll;
    }

    public void setStudentTotalEnroll(int studentTotalEnroll) {
        this.studentTotalEnroll = studentTotalEnroll;
    }

    public Date getStudentRegistrationDate() {
        return studentRegistrationDate;
    }

    public void setStudentRegistrationDate(Date studentRegistrationDate) {
        this.studentRegistrationDate = studentRegistrationDate;
    }

    public Date getStudentLastSeen() {
        return studentLastSeen;
    }

    public void setStudentLastSeen(Date studentLastSeen) {
        this.studentLastSeen = studentLastSeen;
    }

    public String getStudentProfileComplete() {
        return studentProfileComplete;
    }

    public void setStudentProfileComplete(String studentProfileComplete) {
        this.studentProfileComplete = studentProfileComplete;
    }
}

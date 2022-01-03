package com.student.Request;

import com.student.Entity.Subjects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "Class representing Student data requested from User.")
public class AddStudentRequest {

    @ApiModelProperty(
            notes = "Name of the Student.",
            example = "Mayank Devrani",
            required = true,
            position = 1
    )
    @NotBlank
    private String studentName;

    @ApiModelProperty(
            notes = "Username of the Student.",
            example = "xyz98766",
            required = true,
            position = 2
    )
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
    private String studentSchool;

    @ApiModelProperty(
            notes = "Class of the Student",
            example = "Class X",
            required = true,
            position = 7
    )
    @Size(max = 5)
    private String studentClass;

    @ApiModelProperty(
            notes = "List of Subjects of the Student.",
            example = "Maths,Science,etc",
            required = false,
            position = 8
    )
    private List<Subjects> studentSubjects = new ArrayList<>();

    @ApiModelProperty(
            notes = "Career goal of the Student.",
            example = "Doctor",
            required = false,
            position = 9
    )
    @Size(max = 100)
    private String studentCareerGoal;

    @ApiModelProperty(
            notes = "Short Bio of the Student.",
            example = "Hi, my name is xyz from class x.",
            required = false,
            position = 10
    )
    private String studentBio;

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
}

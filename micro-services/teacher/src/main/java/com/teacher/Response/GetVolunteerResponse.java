package com.teacher.Response;

import com.teacher.Entity.AreaOfExpertise;
import com.teacher.Entity.Qualification;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApiModel(description = "Class representing Volunteer data requested from User.")
public class GetVolunteerResponse {


    @ApiModelProperty(
            value = "The primary identifier of the volunteer.",
            required = false,
            accessMode = ApiModelProperty.AccessMode.READ_ONLY,
            example = "eefb648a-75d0-410b-8a98-6a26c1629cbe",
            position = 1
    )
    private String name;

    @ApiModelProperty(
            notes = "Date of Birth of the Volunteer.",
            example = "16/06/1996",
            required = false,
            position = 2
    )
    private Date volunteerDob;

    @ApiModelProperty(
            notes = "Email Address of the Volunteer.",
            example = "DrXyz@gmail.com",
            required = false,
            position = 3
    )
    private String volunteerMail;

    @ApiModelProperty(
            notes = "List of Volunteer Area of Expertise.",
            example = "[Maths,Science]",
            required = false,
            position = 4
    )
    private List<AreaOfExpertise> areaOfExpertiseList = new ArrayList<>();

    @ApiModelProperty(
            notes = "Volunteer available in a week.",
            example = "5 days",
            required = false,
            position = 5
    )
    private String  volunteerAvailability;


    @ApiModelProperty(
            notes = "Username of the Volunteer.",
            example = "Xyz9876",
            required = false,
            position = 6
    )
    @Size(max = 20)
    private String volunteerUsername;

    @ApiModelProperty(
            notes = "Mobile Number of the Volunteer.",
            example = "987653212",
            required = false,
            position = 7
    )
    @Pattern(regexp = "\\+?[0-9. ()-]{10}",message = "Phone Number")
    private String mobileNumber;

    @ApiModelProperty(
            notes = "Short Introduction of Volunteer.",
            example = "Hi, I'm Dr. Xyz from Pune",
            required = false,
            position = 8
    )
    @Size(max = 4000)
    private String volunteerBio;

    @ApiModelProperty(
            notes = "Volunteer highest degree.",
            example = "phd",
            required = false,
            position = 9
    )
    private String volunteerHighestDegree;


    @ApiModelProperty(
            notes = "Volunteer Total experience.",
            example = "5 Years",
            required = false,
            position = 10
    )
    private String teacherExperience;

    @ApiModelProperty(
            notes = "List of Volunteer Qualifications.",
            example = "[BSC,MCA,Mtech]",
            required = false,
            position = 11
    )
    private List<Qualification> qualificationList = new ArrayList<>();

    public GetVolunteerResponse() {
    }

    public GetVolunteerResponse(String name, Date volunteerDob,
                                String volunteerMail, List<AreaOfExpertise> areaOfExpertiseList,
                                String volunteerAvailability, String volunteerUsername,
                                String mobileNumber, String volunteerBio,
                                String volunteerHighestDegree, String teacherExperience,
                                List<Qualification> qualificationList) {
        this.name = name;
        this.volunteerDob = volunteerDob;
        this.volunteerMail = volunteerMail;
        this.areaOfExpertiseList = areaOfExpertiseList;
        this.volunteerAvailability = volunteerAvailability;
        this.volunteerUsername = volunteerUsername;
        this.mobileNumber = mobileNumber;
        this.volunteerBio = volunteerBio;
        this.volunteerHighestDegree = volunteerHighestDegree;
        this.teacherExperience = teacherExperience;
        this.qualificationList = qualificationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getVolunteerDob() {
        return volunteerDob;
    }

    public void setVolunteerDob(Date volunteerDob) {
        this.volunteerDob = volunteerDob;
    }

    public String getVolunteerMail() {
        return volunteerMail;
    }

    public void setVolunteerMail(String volunteerMail) {
        this.volunteerMail = volunteerMail;
    }

    public List<AreaOfExpertise> getAreaOfExpertiseList() {
        return areaOfExpertiseList;
    }

    public void setAreaOfExpertiseList(List<AreaOfExpertise> areaOfExpertiseList) {
        this.areaOfExpertiseList = areaOfExpertiseList;
    }

    public String getVolunteerAvailability() {
        return volunteerAvailability;
    }

    public void setVolunteerAvailability(String volunteerAvailability) {
        this.volunteerAvailability = volunteerAvailability;
    }

    public String getVolunteerUsername() {
        return volunteerUsername;
    }

    public void setVolunteerUsername(String volunteerUsername) {
        this.volunteerUsername = volunteerUsername;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getVolunteerBio() {
        return volunteerBio;
    }

    public void setVolunteerBio(String volunteerBio) {
        this.volunteerBio = volunteerBio;
    }

    public String getVolunteerHighestDegree() {
        return volunteerHighestDegree;
    }

    public void setVolunteerHighestDegree(String volunteerHighestDegree) {
        this.volunteerHighestDegree = volunteerHighestDegree;
    }

    public String getTeacherExperience() {
        return teacherExperience;
    }

    public void setTeacherExperience(String teacherExperience) {
        this.teacherExperience = teacherExperience;
    }

    public List<Qualification> getQualificationList() {
        return qualificationList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }
}
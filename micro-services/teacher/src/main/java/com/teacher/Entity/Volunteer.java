package com.teacher.Entity;

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

@ApiModel(description = "Class representing Teacher or Volunteer in application")
@Entity
@Table(name = "VolunteerInfo")
public class Volunteer implements Serializable {

    private static final long serialVersionId = 4048746876554674863L;

    @ApiModelProperty(
            notes = "Unique Identity of the Volunteer.",
            example = "1",
            required = true,
            position = 0
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volunteerId")
    private Long id;

    @ApiModelProperty(
            notes = "Name of the Volunteer.",
            example = "Dr. Xyz",
            required = true,
            position = 1
    )
    @NotBlank
    @Column(name = "volunteerName")
    private String volunteerName;

    @ApiModelProperty(
            notes = "Username of the Volunteer.",
            example = "Xyz9876",
            required = false,
            position = 2
    )
    @Size(max = 20)
    @Column(name = "volunteerUsername")
    private String volunteerUsername;

    @ApiModelProperty(
            notes = "Date of Birth of the Volunteer.",
            example = "16/06/1996",
            required = true,
            position = 3
    )
    @Column(name = "VolunteerDob")
    private Date volunteerDob;

    @ApiModelProperty(
            notes = "Email Address of the Volunteer.",
            example = "DrXyz@gmail.com",
            required = true,
            position = 4
    )
    @Email(message = "Email Address")
    @Size(max = 100)
    @Column(name = "volunteerMail")
    private String volunteerMail;

    @ApiModelProperty(
            notes = "Mobile Number of the Volunteer.",
            example = "987653212",
            required = false,
            position = 5
    )
    @Pattern(regexp = "\\+?[0-9. ()-]{10}",message = "Phone Number")
    @Size(max = 10)
    @Column(name = "VolunteerMobile")
    private String mobileNumber;

    @ApiModelProperty(
            notes = "Short Introduction of Volunteer.",
            example = "Hi, I'm Dr. Xyz from Pune",
            required = false,
            position = 6
    )
    @Size(max = 4000)
    @Column(name = "volunteerBio")
    private String volunteerBio;

    @ApiModelProperty(
            notes = "List of Volunteer Area of Expertise.",
            example = "[Maths,Science]",
            required = true,
            position = 7
    )
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<AreaOfExpertise> areaOfExpertiseList = new ArrayList<>();

    @ApiModelProperty(
            notes = "Volunteer highest degree.",
            example = "phd",
            required = false,
            position = 8
    )
    @Column(name = "volunteerHighestDegree")
    private String volunteerHighestDegree;

    @ApiModelProperty(
            notes = "Volunteer Total experience.",
            example = "5 Years",
            required = false,
            position = 9
    )
    @Column(name = "teacherExperience")
    private String teacherExperience;

    @ApiModelProperty(
            notes = "List of Volunteer Qualifications.",
            example = "[BSC,MCA,Mtech]",
            required = false,
            position = 10
    )
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Qualification> qualificationList = new ArrayList<>();

   @ApiModelProperty(
           notes = "Volunteer available in a week.",
           example = "5 days",
           required = true,
           position = 11
   )
   @Column(name = "volunteerAvailability")
   private String  volunteerAvailability;

    @ApiModelProperty(
            notes = "Volunteer Registration Date.",
            example = "23/12/2021",
            required = true,
            position = 12
    )
    @Column(name = "registrationDate")
    private Date  registrationDate;

    @ApiModelProperty(
            notes = "Volunteer last time logged in Date.",
            example = "23/12/2021",
            required = true,
            position = 13
    )
    @Column(name = "lastLoggedIn")
    private Date  lastLoggedIn;

    @ApiModelProperty(
            notes = "Volunteer Profile complete.",
            example = "40%",
            required = true,
            position = 14
    )
    @Column(name = "volunteerProfile")
    private String volunteerProfile;

    public Volunteer(String volunteerName, Date volunteerDob, String volunteerMail,
                     String volunteerAvailability, Date registrationDate,
                     String volunteerProfile,String volunteerUsername,
                     String mobileNumber, String volunteerBio,
                     String volunteerHighestDegree, String teacherExperience) {
        this.volunteerName = volunteerName;
        this.volunteerDob = volunteerDob;
        this.volunteerMail = volunteerMail;
        this.volunteerAvailability = volunteerAvailability;
        this.registrationDate = registrationDate;
        this.volunteerProfile = volunteerProfile;
        this.volunteerUsername = volunteerUsername;
        this.mobileNumber = mobileNumber;
        this.volunteerBio = volunteerBio;
        this.volunteerHighestDegree = volunteerHighestDegree;
        this.teacherExperience = teacherExperience;
    }

    public Volunteer() {

    }

    public static long getSerialVersionId() {
        return serialVersionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getVolunteerUsername() {
        return volunteerUsername;
    }

    public void setVolunteerUsername(String volunteerUsername) {
        this.volunteerUsername = volunteerUsername;
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

    public List<AreaOfExpertise> getAreaOfExpertiseList() {
        return areaOfExpertiseList;
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

    public String getVolunteerAvailability() {
        return volunteerAvailability;
    }

    public void setVolunteerAvailability(String volunteerAvailability) {
        this.volunteerAvailability = volunteerAvailability;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getLastLoggedIn() {
        return lastLoggedIn;
    }

    public void setLastLoggedIn(Date lastLoggedIn) {
        this.lastLoggedIn = lastLoggedIn;
    }

    public String getVolunteerProfile() {
        return volunteerProfile;
    }

    public void setAreaOfExpertiseList(List<AreaOfExpertise> areaOfExpertiseList) {
        this.areaOfExpertiseList = areaOfExpertiseList;
    }

    public void setQualificationList(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    public void setVolunteerProfile(String volunteerProfile) {
        this.volunteerProfile = volunteerProfile;
    }
}
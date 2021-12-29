package com.teacher.Service;

import com.teacher.Entity.AreaOfExpertise;
import com.teacher.Entity.Qualification;
import com.teacher.Entity.Volunteer;
import com.teacher.Request.AddVolunteerRequest;
import com.teacher.Response.AddVolunteerResponse;
import com.teacher.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    VolunteerRepository volunteerRepository;

    //Service to add new Volunteer
    public Optional<AddVolunteerResponse> addVolunteer(AddVolunteerRequest addVolunteerRequest){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(formatter.format(date));
        System.out.println(date);

        Volunteer volunteer = new Volunteer(
                addVolunteerRequest.getName(),
                addVolunteerRequest.getVolunteerDob(),
                addVolunteerRequest.getVolunteerMail(),
                addVolunteerRequest.getVolunteerAvailability(),
                date,
                "0",
                addVolunteerRequest.getVolunteerUsername(),
                addVolunteerRequest.getMobileNumber(),
                addVolunteerRequest.getVolunteerBio(),
                addVolunteerRequest.getVolunteerHighestDegree(),
                addVolunteerRequest.getTeacherExperience()
        );

        List<Qualification> qualifications = new ArrayList<>();
        for(int i=0;i<addVolunteerRequest.getQualificationList().size();i++) {
            qualifications.add(
                    new Qualification(addVolunteerRequest.getQualificationList().get(i).getName())
            );
        }

        List<AreaOfExpertise> areaOfExpertiseList = new ArrayList<>();
        for(int i=0;i<addVolunteerRequest.getAreaOfExpertiseList().size();i++) {
            areaOfExpertiseList.add(
                    new AreaOfExpertise(
                            addVolunteerRequest.getAreaOfExpertiseList().get(i).getName()
                    )
            );
        }

        volunteer.setQualificationList(qualifications);
        volunteer.setAreaOfExpertiseList(areaOfExpertiseList);

        Volunteer vv = volunteerRepository.save(volunteer);
        AddVolunteerResponse addVolunteerResponse = new AddVolunteerResponse(
                vv.getId(),
                vv.getRegistrationDate()
        );
        return Optional.of(addVolunteerResponse);
    }

   //Service for updating Volunteer Profile

    private String updateProfile(AddVolunteerRequest addVolunteerRequest, Long id){
        Volunteer profileVolunteer = new Volunteer();

        List<Qualification> qualifications = new ArrayList<>();
        for(int i=0;i<addVolunteerRequest.getQualificationList().size();i++) {
            qualifications.add(
                    new Qualification(addVolunteerRequest.getQualificationList().get(i).getName())
            );
        }
        profileVolunteer.setQualificationList(qualifications);
        volunteerRepository.updateVolunteerPrrofile(addVolunteerRequest.getVolunteerUsername(),
                addVolunteerRequest.getMobileNumber(),
                addVolunteerRequest.getVolunteerBio(),
                addVolunteerRequest.getVolunteerHighestDegree(),
                id);
        return "changed";
    }

    private Date updateLoggedInDate(Long uuid){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(formatter.format(date));
        System.out.println(date);
        return date;
    }

    private boolean updateProfilePercentage(Long uuid){
        return true;
    }
}

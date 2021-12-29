package com.teacher.repository;

import com.teacher.Entity.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer,Long> {

    public Boolean findByVolunteerMail(String email);

    @Modifying
    @Query("update Volunteer v set " +
            "v.volunteerUsername = :username," +
            "v.VolunteerMobile = :mobile," +
            "v.volunteerBio = :bio," +
            "v.volunteerHighestDegree = :degree" +
            "where v.volunteerId : id, " +
            "nativeQuery = true")
    int updateVolunteerPrrofile(String username, String mobile,
                                String bio,String degree,
                                Long id);

    @Modifying
    @Query("update Volunteer v set" +
            "v.lastLoggedIn = :lastLoggedIn" +
            "where v.volunteerId : id," +
            "nativeQuery = true")
    int updateVolunteerLastLogTime(Date lastLoggedIn,Long id);
}
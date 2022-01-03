package com.student.Repository;

import com.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public Boolean findByStudentMail(String mail);

    @Modifying
    @Query("update Student stud set" +
            "stud.studentSchool = :studentSchool," +
            "stud.studentCareerGoal = :studentCareerGoal," +
            "stud.studentBio = :studentBio," +
            "where stud.studentId = :studentId," +
            "nativeQuery = true")
    int updateStudentProfile(String studentSchool,
                             String studentCareerGoal,
                             String studentBio,
                             Long studentId);

    @Modifying
    @Query("update Student stud set" +
            "stud.studentLastSeen = :lastLoggedIn" +
            "where stud.studentId : id," +
            "nativeQuery = true")
    int updateStudentLastLogTime(Date lastLoggedIn, Long id);


}
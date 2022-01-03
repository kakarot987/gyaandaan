package com.courseassign.courses.Repository;

import com.courseassign.courses.Entity.StudentCourse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentCourseRepository extends MongoRepository<StudentCourse,String> {
}

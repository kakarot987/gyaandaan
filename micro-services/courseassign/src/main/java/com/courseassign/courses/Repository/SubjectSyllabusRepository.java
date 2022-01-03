package com.courseassign.courses.Repository;

import com.courseassign.courses.Entity.SubjectSyllabus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectSyllabusRepository extends MongoRepository<SubjectSyllabus,String> {
}

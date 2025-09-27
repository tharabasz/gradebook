package org.gradebook.school.student.domain.port;

import org.gradebook.school.student.domain.model.StudentAggregate;

import java.util.Optional;

public interface EnrolledStudentRepository {
    Optional<StudentAggregate> findById(String candidateId);
}

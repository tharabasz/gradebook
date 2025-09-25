package org.gradebook.student.domain.port;

import org.gradebook.student.domain.model.StudentAggregate;

import java.util.Optional;

public interface EnrolledStudentRepository {
    Optional<StudentAggregate> findById(String candidateId);
}

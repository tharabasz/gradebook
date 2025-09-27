package org.gradebook.school.student.domain.port;

import org.gradebook.school.student.domain.model.StudentAggregate;

import java.util.Optional;

public interface StudentRepositoryPort {
   Optional<StudentAggregate> findById(Long id);
   StudentAggregate save(StudentAggregate classroom);
}

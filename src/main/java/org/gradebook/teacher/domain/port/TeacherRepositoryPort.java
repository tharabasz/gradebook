package org.gradebook.teacher.domain.port;

import org.gradebook.teacher.domain.model.TeacherAggregate;

import java.util.Optional;

public interface TeacherRepositoryPort {
    Optional<TeacherAggregate> findById(Long teacherId);
}

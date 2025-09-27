package org.gradebook.school.teacher.domain.port;

import org.gradebook.school.teacher.domain.model.TeacherAggregate;

import java.util.Optional;

public interface TeacherRepositoryPort {
    Optional<TeacherAggregate> findById(Long teacherId);
}

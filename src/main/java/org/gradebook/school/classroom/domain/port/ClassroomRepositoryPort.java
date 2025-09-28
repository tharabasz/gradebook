package org.gradebook.school.classroom.domain.port;

import org.gradebook.school.classroom.domain.model.ClassroomAggregate;

import java.util.Optional;

public interface
ClassroomRepositoryPort {
    Optional<ClassroomAggregate> findById(String classroomId);
    void save(ClassroomAggregate classroom);
}

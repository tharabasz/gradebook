package org.gradebook.classroom.domain.port;

import org.gradebook.classroom.domain.model.ClassroomAggregate;

import java.util.Optional;

public interface ClassroomRepositoryPort {
    Optional<ClassroomAggregate> findById(Long classroomId);

    void save(ClassroomAggregate classroom);
}

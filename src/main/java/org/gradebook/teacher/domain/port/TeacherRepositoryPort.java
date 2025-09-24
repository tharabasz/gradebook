package org.gradebook.teacher.domain.port;

import java.util.Optional;

public interface TeacherRepositoryPort {
    Optional<Object> findById(Long teacherId);
}

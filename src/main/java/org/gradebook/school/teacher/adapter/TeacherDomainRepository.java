package org.gradebook.school.teacher.adapter;

import lombok.AllArgsConstructor;
import org.gradebook.school.teacher.domain.model.TeacherAggregate;
import org.gradebook.school.teacher.domain.port.TeacherRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TeacherDomainRepository implements TeacherRepositoryPort {
    private final TeacherJpaRepository jpa;

    @Override
    public Optional<TeacherAggregate> findById(String teacherId) {
        return Optional.empty();
    }
}
package org.gradebook.teacher.adapter;

import lombok.AllArgsConstructor;
import org.gradebook.student.adapter.StudentJpaRepository;
import org.gradebook.student.domain.model.StudentAggregate;
import org.gradebook.student.domain.port.StudentRepositoryPort;
import org.gradebook.teacher.domain.model.TeacherAggregate;
import org.gradebook.teacher.domain.port.TeacherRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class TeacherDomainRepository implements TeacherRepositoryPort {
    private final TeacherJpaRepository jpa;

    @Override
    public Optional<TeacherAggregate> findById(Long id) {
       // return jpa.findById(id).map()//mapstruct
        return Optional.empty();
    }
}
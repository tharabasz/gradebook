package org.gradebook.student.adapter;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.gradebook.classroom.domain.model.ClassroomAggregate;
import org.gradebook.student.domain.model.StudentAggregate;
import org.gradebook.student.domain.port.StudentRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class StudentDomainRepository implements StudentRepositoryPort {
    private final StudentJpaRepository jpa;

    @Override
    public Optional<StudentAggregate> findById(Long id) {
       // return jpa.findById(id).map()//mapstruct
        return Optional.empty();
    }
}
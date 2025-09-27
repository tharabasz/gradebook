package org.gradebook.school.student.adapter;

import lombok.AllArgsConstructor;
import org.gradebook.school.student.domain.model.StudentAggregate;
import org.gradebook.school.student.domain.port.StudentRepositoryPort;
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

    @Override
    public StudentAggregate save(StudentAggregate classroom) {
        return null;
    }


}
package org.gradebook.classroom.adapter;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.gradebook.classroom.domain.model.ClassroomAggregate;
import org.gradebook.classroom.domain.port.ClassroomRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ClassroomDomainRepository implements ClassroomRepositoryPort {
    private final ClassroomJpaRepository jpa;

    @Override
    public Optional<ClassroomAggregate> findById(Long id) {
       // return jpa.findById(id).map()//mapstruct
        return Optional.empty();
    }

    @Override
    @Transactional
    public ClassroomAggregate save(ClassroomAggregate aggregate) {
        return ClassroomAggregate.initializeClassroom(1L, "", "", 1111);
    }
}
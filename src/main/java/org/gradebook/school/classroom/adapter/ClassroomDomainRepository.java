package org.gradebook.school.classroom.adapter;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.gradebook.school.classroom.adapter.mapper.ClassroomMapper;
import org.gradebook.school.classroom.domain.model.ClassroomAggregate;
import org.gradebook.school.classroom.domain.port.ClassroomRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ClassroomDomainRepository implements ClassroomRepositoryPort {
    private final ClassroomJpaRepository jpa;
    private final ClassroomMapper classroomMapper;

    @Override
    public Optional<ClassroomAggregate> findById(String classroomId) {
        return jpa.findById(classroomId)
                .map(classroomMapper::toAggregate);
    }

    @Override
    @Transactional
    public void save(ClassroomAggregate classroomAggregate) {
        jpa.save(classroomMapper.toEntity(classroomAggregate));
    }
}
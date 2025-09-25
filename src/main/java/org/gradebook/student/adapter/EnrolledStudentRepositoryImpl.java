package org.gradebook.student.adapter;

import lombok.RequiredArgsConstructor;
import org.gradebook.student.domain.model.StudentAggregate;
import org.gradebook.student.domain.port.EnrolledStudentRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class EnrolledStudentRepositoryImpl implements EnrolledStudentRepository {
    StudentJpaRepository jpaRepository;

    @Override
    public Optional<StudentAggregate> findById(String candidateId) {
        return Optional.empty();
    }
}

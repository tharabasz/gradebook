package org.gradebook.student.adapter;

import lombok.RequiredArgsConstructor;
import org.gradebook.student.domain.model.StudentAggregate;
import org.gradebook.student.domain.port.OnboardedStudentDetailsRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class OnboardedStudentDetailsRepositoryImpl implements OnboardedStudentDetailsRepository {
    StudentJpaRepository jpaRepository;

    @Override
    public Optional<StudentAggregate> findById(String candidateId) {
        return Optional.empty();
    }
}

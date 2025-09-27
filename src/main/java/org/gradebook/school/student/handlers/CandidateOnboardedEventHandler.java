package org.gradebook.school.student.handlers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.gradebook.admission.candidate.domain.events.CandidateOnboardedEvent;
import org.gradebook.school.student.adapter.StudentDomainRepository;
import org.gradebook.school.student.domain.port.EnrolledStudentRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CandidateOnboardedEventHandler {
    EnrolledStudentRepository onboardedStudentDetailsRepository;
    StudentDomainRepository studentDomainRepository;

    @EventListener
    public void handle(CandidateOnboardedEvent event) {
        onboardedStudentDetailsRepository
                .findById(event.candidateId())
                .ifPresentOrElse(
                        student -> {
                            student.onboardStudent();
                            studentDomainRepository.save(student);
                        },
                        () -> log.info("Candidate not exist", event.candidateId())
                );
    }
}

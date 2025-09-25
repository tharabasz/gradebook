package org.gradebook.candidate.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import org.gradebook.DomainEvent;
import org.gradebook.candidate.domain.events.CandidateOnboardedEvent;
import org.gradebook.candidate.domain.events.CandidateRejectedEvent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
public class CandidateAggregate {

    private final Long candidateId;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate appliedDate;
    private CandidateStatus status; // APPLIED, ACCEPTED, REJECTED, CONVERTED
    @Default
    List<DomainEvent> events = new ArrayList<>();

    public static CandidateAggregate initialise(Long id, String firstName, String lastName, String email) {
        return CandidateAggregate.builder()
                .candidateId(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .appliedDate(LocalDate.now())
                .status(CandidateStatus.APPLIED)
                .build();
    }

    public void accept() {
        if (status != CandidateStatus.APPLIED) {
            throw new IllegalStateException("Only new candidates can be accepted");
        }
        this.status = CandidateStatus.ACCEPTED;
    }

    public void reject() {
        this.status = CandidateStatus.REJECTED;
        events.add(CandidateRejectedEvent.builder().build());

    }

    public void onboardToStudent(LocalDate enrollmentDate) {
        if (status != CandidateStatus.ACCEPTED) {
            throw new IllegalStateException("Candidate must be accepted before becoming a student");
        }
        this.status = CandidateStatus.ENROLLED;
        events.add(CandidateOnboardedEvent.builder().build());
    }
}
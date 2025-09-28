package org.gradebook.school.student.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Builder.Default;
import org.gradebook.DomainEvent;
import org.gradebook.school.student.domain.events.StudentOnboardedEvent;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class StudentAggregate {

    private StudentId studentId;
    private String name;
    private String email;
    private EnrollmentStatus status;
    @Default
    private final Set<DomainEvent> domainEvents = new HashSet<>();

    public void onboardStudent() {
        if (this.status != EnrollmentStatus.PENDING_ONBOARDING) {
            throw new IllegalStateException("Student is not in a state to be onboarded.");
        }

        this.status = EnrollmentStatus.ACTIVE;
        domainEvents.add(new StudentOnboardedEvent(this.studentId.studentId()));
    }
}
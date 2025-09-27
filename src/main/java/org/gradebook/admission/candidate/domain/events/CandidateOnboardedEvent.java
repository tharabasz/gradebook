package org.gradebook.admission.candidate.domain.events;

import lombok.Builder;
import org.gradebook.DomainEvent;

@Builder
public record CandidateOnboardedEvent(String candidateId) implements DomainEvent { }

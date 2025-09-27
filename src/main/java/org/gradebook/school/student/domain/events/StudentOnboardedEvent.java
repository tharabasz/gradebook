package org.gradebook.school.student.domain.events;

import org.gradebook.DomainEvent;

import java.util.UUID;

public record StudentOnboardedEvent(UUID studentId) implements DomainEvent { }

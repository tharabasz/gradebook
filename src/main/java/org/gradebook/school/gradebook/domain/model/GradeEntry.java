package org.gradebook.school.gradebook.domain.model;

import java.time.LocalDate;

public record GradeEntry(
        String description,
        GradeValue value,
        LocalDate date,
        TeacherId teacherId) {

    private class TeacherId {
    }
}
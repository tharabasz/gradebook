package org.gradebook.school.gradebook.domain.model;

public record SemesterGrade(
        SemesterVo semester,
        GradeValue value
) {}
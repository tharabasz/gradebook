package org.gradebook.school.gradebook.domain.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
public class GradebookAggregarte {
    private final GradebookId id;
    private final StudentId studentId;
    private final SubjectId subjectId;
    private final SemesterVo semester;
    private final int year;

    @Default
    private final List<GradeEntry> partialGrades = new ArrayList<>();
    private SemesterGrade semesterGrade;
    private FinalGrade finalGrade;

    private static GradebookAggregarte initialize (SemesterVo semester, int year) {
        return GradebookAggregarte.builder()
                .id(new GradebookId(UUID.randomUUID().toString()))
                .semester(semester)
                .year(year)
                .build();
    }
    public void addPartialGrade(@NonNull GradeEntry grade) {
        partialGrades.add(grade);
    }

    public void calculateSemesterGrade(SemesterVo semester) {
        if (partialGrades.isEmpty()) {
            throw new IllegalStateException("Cannot calculate semester grade without partial grades");
        }

        double avg = partialGrades.stream()
                .mapToDouble(g -> g.value().numericValue())
                .average()
                .orElseThrow();

        GradeValue semesterValue = GradeValue.fromNumeric(avg);
        this.semesterGrade = new SemesterGrade(semester, semesterValue);
    }

    public void adjustSemesterGrade(SemesterVo semester, String comment, GradeValue adjustment) {
        if (semesterGrade == null) {
            throw new IllegalStateException("Cannot adjust semester grade if its not exists!");
        }

        double avg = partialGrades.stream()
                .mapToDouble(g -> g.value().numericValue())
                .average()
                .orElseThrow();

        GradeValue semesterValue = GradeValue.fromNumeric(avg);
        this.semesterGrade = new SemesterGrade(semester, semesterValue);
    }

    public void assignFinalGrade(FinalGrade finalGrade) {
        if (semesterGrade == null) {
            throw new IllegalStateException("Cannot assign final grade before semester grade is calculated");
        }
        this.finalGrade = finalGrade;
    }
}
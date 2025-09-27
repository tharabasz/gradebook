package org.gradebook.school.gradebook.domain.model;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class GradebookAggregarte {  // Aggregate Root
    private final GradebookId id;
    private final StudentId studentId;
    private final SubjectId subjectId;
    private final SemesterVo semester;   // NEW
    private final int year;

    @Default
    private final List<GradeEntry> partialGrades;
    private SemesterGrade semesterGrade;
    private FinalGrade finalGrade;

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

    private class GradebookId {
    }

    private class StudentId {
    }

    private class SubjectId {
    }
}
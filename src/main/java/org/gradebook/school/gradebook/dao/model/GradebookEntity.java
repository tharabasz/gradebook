package org.gradebook.school.gradebook.dao.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "gradebook",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"student_id", "subject_id", "semester", "    year"}
        ))
public class GradebookEntity {

    @Id
    @Column(columnDefinition = "uuid")
    private String id;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @Column(name = "subject_id", nullable = false)
    private String subjectId;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "year", nullable = false)
    private int year;

    @OneToMany(mappedBy = "gradebook", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GradeEntryEntity> partialGrades;

    @OneToOne(mappedBy = "gradebook", cascade = CascadeType.ALL, orphanRemoval = true)
    private SemesterGradeEntity semesterGrade;

    @OneToOne(mappedBy = "gradebook", cascade = CascadeType.ALL, orphanRemoval = true)
    private FinalGradeEntity finalGrade;

}
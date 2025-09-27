package org.gradebook.school.gradebook.dao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "grade_entry")
@Data
public class GradeEntryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String description;
    private String gradeValue;
    private String teacherId;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "gradebook_id", nullable = false)
    private GradebookEntity gradebook;
}
package org.gradebook.school.gradebook.dao.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "final_grade")
@Data
public class FinalGradeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "grade_value", nullable = false)
    private String gradeValue;

    @OneToOne
    @JoinColumn(name = "gradebook_id", nullable = false, unique = true)
    private GradebookEntity gradebook;
}
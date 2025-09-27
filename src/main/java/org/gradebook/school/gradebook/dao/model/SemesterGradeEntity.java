package org.gradebook.school.gradebook.dao.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "semester_grade")
@Data
public class SemesterGradeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "semester", nullable = false)
    private int semester;

    @Column(name = "grade_value", nullable = false)
    private String gradeValue;

    @OneToOne
    @JoinColumn(name = "gradebook_id", nullable = false, unique = true)
    private GradebookEntity gradebook;

}
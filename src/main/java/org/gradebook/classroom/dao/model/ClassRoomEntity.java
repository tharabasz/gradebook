package org.gradebook.classroom.dao.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static org.gradebook.classroom.dao.model.ClassRoomEntity.TABLE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = TABLE)
public class ClassRoomEntity {
    public static final String TABLE = "classroom";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String grade;
    private Integer year;

    @Column(name = "teacher_id")
    private String teacherId; // reference by UUID/ID string

    @ElementCollection
    @CollectionTable(name = "classroom_students", joinColumns = @JoinColumn(name = "classroom_id"))
    @Column(name = "student_id")
    private List<String> studentIds;

    @ElementCollection
    @CollectionTable(name = "classroom_subjects", joinColumns = @JoinColumn(name = "classroom_id"))
    @Column(name = "subject")
    private List<String> subjects;

    @Column(columnDefinition = "TEXT")
    private String schedule; // JSON or string

    private String roomNumber;

    @Column(columnDefinition = "TEXT")
    private String notes;
}

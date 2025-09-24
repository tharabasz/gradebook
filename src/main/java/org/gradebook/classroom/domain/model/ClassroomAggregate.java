package org.gradebook.classroom.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassroomAggregate {

    private Long id;
    private String name;
    private String grade;
    private Integer year;
    private String roomNumber;
    private String notes;
    private Long teacherId;
    private final List<Long> studentIds = new ArrayList<>();

    public ClassroomAggregate(Long id, String name, String grade, Integer year, Long teacherId, List<Long> studentIds) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.year = year;
        this.teacherId = teacherId;
        if (studentIds != null)
            this.studentIds.addAll(studentIds);
    }

    public Long getId() { return id; }
    public List<Long> getStudentIds() { return List.copyOf(studentIds); }
    public Long getTeacherId() { return teacherId; }

    public void assignStudent(Long studentId) {
        Objects.requireNonNull(studentId, "studentId must not be null");
        if (!studentIds.contains(studentId)) {
            studentIds.add(studentId);
        }
    }

    public void assignTeacher(Long teacherId) {
        Objects.requireNonNull(teacherId, "teacherId must not be null");
        this.teacherId = teacherId;
    }

    public static ClassroomAggregate initializeClassroom(Long id, String name, String grade, Integer year) {
        return new ClassroomAggregate(id, name, grade, year, null, new ArrayList<>());
    }
}

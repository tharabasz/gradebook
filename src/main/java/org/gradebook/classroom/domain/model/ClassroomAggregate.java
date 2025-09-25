package org.gradebook.classroom.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Builder
public class ClassroomAggregate {

    private Long id;
    private String name;
    private String grade;
    private Integer year;
    private String roomNumber;
    private String notes;
    private Long teacherId;
    private final List<Long> studentIds = new ArrayList<>();

    public static ClassroomAggregate initializeClassroom(Long id, String name, String grade, Integer year) {
        return ClassroomAggregate.builder()
                .id(id)
                .name(name)
                .grade(grade)
                .year(year)
                .build();
    }

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

    public void removeStudent(Long studentId) {
        studentIds.remove(studentId);
    }

    public boolean hasStudent(Long studentId) {
        return studentIds.contains(studentId);
    }

    public void changeRoom(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}

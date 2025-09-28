package org.gradebook.school.classroom.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Builder
public class ClassroomAggregate {

    private ClassroomId classroomId;
    private TeacherId teacherId;
    private Integer year;

    private String name;
    private String grade;
    private String roomNumber;
    private String notes;
    private final List<StudentId> studentIds = new ArrayList<>();

    public static ClassroomAggregate initializeClassroom(String name, String grade, Integer year) {
        return ClassroomAggregate.builder()
                .classroomId(new ClassroomId(UUID.randomUUID().toString()))
                .name(name)
                .grade(grade)
                .year(year)
                .build();
    }

    public void assignStudent(String studentId) {
        Objects.requireNonNull(studentId, "studentId must not be null");
        StudentId studentIdVo = new StudentId(studentId);
        if (!studentIds.contains(studentIdVo)) {
            studentIds.add(studentIdVo);
        }
    }

    public void assignTeacher(String teacherId) {
        Objects.requireNonNull(teacherId, "teacherId must not be null");
        this.teacherId = new TeacherId(teacherId);
    }

    public void removeStudent(String studentId) {
        studentIds.remove(new StudentId(studentId));
    }

    public boolean hasStudent(String studentId) {
        return studentIds.contains(new StudentId(studentId));
    }

    public void changeRoom(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}

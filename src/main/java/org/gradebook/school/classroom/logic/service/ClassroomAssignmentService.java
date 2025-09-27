package org.gradebook.school.classroom.logic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.gradebook.school.classroom.domain.port.ClassroomRepositoryPort;
import org.gradebook.school.student.domain.port.StudentRepositoryPort;
import org.gradebook.school.teacher.domain.port.TeacherRepositoryPort;

@Service
public class ClassroomAssignmentService {

    private final ClassroomRepositoryPort classroomRepository;
    private final StudentRepositoryPort studentRepository;
    private final TeacherRepositoryPort teacherRepository;

    public ClassroomAssignmentService(ClassroomRepositoryPort classroomRepository,
                                      StudentRepositoryPort studentRepository,
                                      TeacherRepositoryPort teacherRepository) {
        this.classroomRepository = classroomRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Transactional
    public void assignStudentToClassroom(Long studentId, Long classroomId) {

        studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found: " + studentId));

        classroomRepository.findById(classroomId)
                .ifPresentOrElse(classroomAggregate -> {
                    classroomAggregate.assignStudent(studentId);
                    classroomRepository.save(classroomAggregate);
                }, () -> new IllegalArgumentException("classroom not found: " + classroomId));
    }

    @Transactional
    public void assignTeacherToClassroom(Long teacherId, Long classroomId) {
        teacherRepository.findById(teacherId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found: " + teacherId));

        classroomRepository.findById(classroomId)
                .ifPresentOrElse(classroomAggregate -> {
                    classroomAggregate.assignStudent(teacherId);
                    classroomRepository.save(classroomAggregate);
                }, () -> new IllegalArgumentException("teacher not found: " + teacherId));
    }
}

package org.gradebook.school.classroom.adapter.mapper;
import org.gradebook.school.classroom.domain.model.StudentId;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    // Custom method to map one StudentId to String
    default String map(StudentId studentId) {
        return studentId == null ? null : studentId.studentId();
    }

    List<String> mapStudentIds(List<StudentId> studentIds);
}

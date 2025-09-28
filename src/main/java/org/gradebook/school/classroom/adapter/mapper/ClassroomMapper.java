package org.gradebook.school.classroom.adapter.mapper;

import org.gradebook.school.classroom.dao.model.ClassRoomEntity;
import org.gradebook.school.classroom.domain.model.ClassroomAggregate;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClassroomMapper {

    @Mapping(target = "classroomId.classroomId", source = "id")
    @Mapping(target = "teacherId.teacherId", source = "teacherId")
    ClassroomAggregate toAggregate(ClassRoomEntity entity);

    //@Mapping(target = "id", source = "aggregate.classroomId.classroomId")
    //@Mapping(target = "teacherId", source = "aggregate.teacherId.teacherId")
    //@Mapping(target = "studentIds", source = "aggregate.studentIds.studentId")
    ClassRoomEntity toEntity(ClassroomAggregate aggregate);

}

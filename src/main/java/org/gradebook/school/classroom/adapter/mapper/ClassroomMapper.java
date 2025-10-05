package org.gradebook.school.classroom.adapter.mapper;

import org.gradebook.school.classroom.dao.model.ClassRoomEntity;
import org.gradebook.school.classroom.domain.model.ClassroomAggregate;
import org.mapstruct.*;

@Mapper(componentModel = "spring",
        uses = StudentMapper.class)
public interface ClassroomMapper {

    @Mapping(target = "classroomId.classroomId", source = "id")
    @Mapping(target = "teacherId.teacherId", source = "teacherId")
    ClassroomAggregate toAggregate(ClassRoomEntity entity);

    @Mapping(target = "id", source = "classroomId.classroomId")
    @Mapping(target = "teacherId", source = "teacherId.teacherId")
    @Mapping(target = "studentIds", source = "studentIds")
    ClassRoomEntity toEntity(ClassroomAggregate aggregate);

}

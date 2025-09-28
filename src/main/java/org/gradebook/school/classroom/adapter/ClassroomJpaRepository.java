package org.gradebook.school.classroom.adapter;

import org.gradebook.school.classroom.dao.model.ClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomJpaRepository extends JpaRepository<ClassRoomEntity, String> {
}

package org.gradebook.classroom.adapter;

import org.gradebook.classroom.dao.model.ClassRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomJpaRepository extends JpaRepository<ClassRoomEntity, Long> {
}

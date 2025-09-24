package org.gradebook.classroom.adapter;

import org.gradebook.classroom.dao.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassroomJpaRepository extends JpaRepository<ClassRoom, Long> {
}

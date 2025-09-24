package org.gradebook.teacher.adapter;

import org.gradebook.teacher.dao.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJpaRepository extends JpaRepository<TeacherEntity, Long> {
}

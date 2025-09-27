package org.gradebook.school.teacher.adapter;

import org.gradebook.school.teacher.dao.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherJpaRepository extends JpaRepository<TeacherEntity, Long> {
}

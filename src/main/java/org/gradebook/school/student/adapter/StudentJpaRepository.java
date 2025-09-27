package org.gradebook.school.student.adapter;

import org.gradebook.school.student.dao.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
}

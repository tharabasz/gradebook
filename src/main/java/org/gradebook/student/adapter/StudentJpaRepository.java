package org.gradebook.student.adapter;

import org.gradebook.student.dao.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {
}

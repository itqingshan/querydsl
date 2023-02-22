package com.dsl.repository;

import com.dsl.domain.Student;
import com.dsl.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}

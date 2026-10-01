package com.auspify_tech.student_management_system.repository;

import com.auspify_tech.student_management_system.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    boolean existsByStudentNumber(String studentNumber);

    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByEmail(String email);

}

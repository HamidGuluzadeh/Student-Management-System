package com.auspify_tech.student_management_system.service;

import com.auspify_tech.student_management_system.dto.request.StudentRequest;
import com.auspify_tech.student_management_system.dto.response.StudentResponse;
import org.springframework.data.domain.Page;

public interface StudentService {

    Page<StudentResponse> getAllStudents(int page, int size);

    StudentResponse getStudentById(Integer id);

    StudentResponse createStudent(StudentRequest request);

    StudentResponse updateStudent(Integer id, StudentRequest request);

    void deleteStudent(Integer id);

}

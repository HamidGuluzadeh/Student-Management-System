package com.auspify_tech.student_management_system.service.implement;

import com.auspify_tech.student_management_system.dto.request.StudentRequest;
import com.auspify_tech.student_management_system.dto.response.StudentResponse;
import com.auspify_tech.student_management_system.entity.StudentEntity;
import com.auspify_tech.student_management_system.exception.ResourceAlreadyExistsException;
import com.auspify_tech.student_management_system.exception.ResourceNotFoundException;
import com.auspify_tech.student_management_system.mapper.StudentMapper;
import com.auspify_tech.student_management_system.repository.StudentRepository;
import com.auspify_tech.student_management_system.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
    StudentMapper studentMapper;

    @Override
    public Page<StudentResponse> getAllStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<StudentEntity> studentEntities = studentRepository.findAll(pageable);

        return studentEntities.map(studentMapper::mapEntityToResponse);
    }

    @Override
    public StudentResponse getStudentById(Integer id) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found!"));

        return studentMapper.mapEntityToResponse(studentEntity);
    }

    @Override
    @Transactional
    public StudentResponse createStudent(StudentRequest request) {
        validateRequest(request);

        StudentEntity studentEntity = studentMapper.mapRequestToEntity(request);

        return studentMapper.mapEntityToResponse(studentEntity);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(Integer id, StudentRequest request) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found!"));

        validateRequest(request);

        studentMapper.updateEntityFromRequest(request, studentEntity);

        return studentMapper.mapEntityToResponse(studentEntity);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found!");
        }

        studentRepository.deleteById(id);
    }

    private void validateRequest(StudentRequest request) {
        if (studentRepository.existsByStudentNumber(request.studentNumber())) {
            throw new ResourceAlreadyExistsException("Student " + request.studentNumber() + " already exists");
        }

        if (studentRepository.existsByPhoneNumber(request.phoneNumber())) {
            throw new ResourceAlreadyExistsException("Phone number already exists!");
        }

        if (studentRepository.existsByEmail(request.email())) {
            throw new ResourceAlreadyExistsException("Email already exists!");
        }
    }
}

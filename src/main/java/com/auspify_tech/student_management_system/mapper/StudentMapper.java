package com.auspify_tech.student_management_system.mapper;

import com.auspify_tech.student_management_system.dto.request.StudentRequest;
import com.auspify_tech.student_management_system.dto.response.StudentResponse;
import com.auspify_tech.student_management_system.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {

    StudentResponse mapEntityToResponse(StudentEntity studentEntity);

    StudentEntity mapRequestToEntity(StudentRequest request);

    void updateEntityFromRequest(StudentRequest request, @MappingTarget StudentEntity studentEntity);

}

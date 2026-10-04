package com.auspify_tech.student_management_system.mapper;

import com.auspify_tech.student_management_system.dto.request.StudentRequest;
import com.auspify_tech.student_management_system.dto.response.StudentResponse;
import com.auspify_tech.student_management_system.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface StudentMapper {

    StudentResponse mapEntityToResponse(StudentEntity studentEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    StudentEntity mapRequestToEntity(StudentRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "studentNumber", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateEntityFromRequest(StudentRequest request, @MappingTarget StudentEntity studentEntity);

}

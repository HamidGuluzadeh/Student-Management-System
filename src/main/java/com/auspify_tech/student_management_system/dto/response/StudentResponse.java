package com.auspify_tech.student_management_system.dto.response;

import lombok.Builder;

import java.time.Instant;
import java.time.LocalDate;

@Builder
public record StudentResponse(String id,
                              String studentNumber,
                              String firstName,
                              String lastName,
                              String phoneNumber,
                              String email,
                              String major,
                              LocalDate enrollmentDate,
                              Instant createdAt,
                              Instant updatedAt) {

}

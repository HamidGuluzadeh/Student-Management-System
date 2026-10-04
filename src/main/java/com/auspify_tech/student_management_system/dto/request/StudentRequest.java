package com.auspify_tech.student_management_system.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record StudentRequest(@NotBlank(message = "Student number cannot be empty!")
                             @Size(min = 10, max = 10, message = "Student number must contain 10 characters!")
                             String studentNumber,
                             @NotBlank(message = "First name cannot be empty!")
                             @Size(min = 3, message = "First name must have at least 3 characters!")
                             @Size(max = 30, message = "First name cannot exceed 30 characters!")
                             String firstName,
                             @NotBlank(message = "Last name cannot be empty!")
                             @Size(max = 50, message = "Last name cannot exceed 50 characters!")
                             String lastName,
                             @NotBlank(message = "Phone number cannot be empty!")
                             @Size(max = 20, message = "Phone number cannot exceed 20 characters!")
                             String phoneNumber,
                             @Size(max = 100, message = "Email cannot exceed 100 characters!")
                             String email,
                             @NotBlank(message = "Major cannot be empty!")
                             @Size(max = 60, message = "Major cannot exceed 60 characters!")
                             String major,
                             @NotNull(message = "Enrollment date cannot be empty!")
                             LocalDate enrollmentDate) {

}

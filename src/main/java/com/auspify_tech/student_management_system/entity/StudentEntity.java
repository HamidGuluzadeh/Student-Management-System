package com.auspify_tech.student_management_system.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    Integer id;

    @Column(name = "student_number", length = 10, nullable = false, unique = true)
    String studentNumber;

    @Column(name = "first_name", length = 30, nullable = false)
    String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    String lastName;

    @Column(name = "phone_number", length = 20, nullable = false, unique = true)
    String phoneNumber;

    @Column(name = "email", length = 100)
    String email;

    @Column(name = "major", length = 60, nullable = false)
    String major;

    @Column(name = "enrollment_date", nullable = false, updatable = false)
    LocalDate enrollmentDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    Instant updatedAt;
}

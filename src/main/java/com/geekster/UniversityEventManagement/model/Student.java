package com.geekster.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @NotNull(message = "Student ID cannot be empty")
    private Long studentId;
    @Pattern(regexp = "^[A-Z].*", message = "First name should start with a capital letter")
    private String studentFirstName;
    @NotBlank(message = "Last name is required")
    private String studentLastName;
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 25, message = "Age must not exceed 25")
    private Integer studentAge;
    @NotNull(message = "Student Department cannot be empty")
    private Department studentDepartment;
}

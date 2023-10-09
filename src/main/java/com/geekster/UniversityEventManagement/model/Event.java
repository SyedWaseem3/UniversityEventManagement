package com.geekster.UniversityEventManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {
    @Id
    @NotNull(message = "Event ID cannot be empty")
    private Long eventId;

    @NotBlank(message = "Event name cannot be blank")
    private String eventName;

    @NotBlank(message = "Event location cannot be blank")
    private String eventLocation;

    @NotNull(message = "Event date cannot be empty")
    private LocalDate eventDate;

    @NotNull(message = "Event start time cannot be empty")
    private LocalTime eventStartTime;

    @NotNull(message = "Event end time cannot be empty")
    private LocalTime eventEndTime;
}

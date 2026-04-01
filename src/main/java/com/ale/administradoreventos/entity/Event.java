package com.ale.administradoreventos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventId;

    @NotBlank(message = "No puede estar en blanco")
    @Size(min = 2, max = 70, message = "El nombre del evento debe tener 2-70 caracteres")
    @Column(name = "event_name", length = 70, nullable = false)
    private String eventName;

    @Size(min = 2, max = 250, message = "La descripción del evento debe tener 2-250 caracteres")
    @Column(name = "event_description", length = 250)
    private String eventDescription;

    @Column(name = "event_date")
    @NotNull
    private LocalDateTime eventDate;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "dress_code")
    private String dressCode;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_capacity")
    @Min(1)
    private Integer eventCapacity;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}

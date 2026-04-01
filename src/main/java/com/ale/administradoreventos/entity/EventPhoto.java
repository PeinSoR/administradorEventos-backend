package com.ale.administradoreventos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_photos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eventPhotosId;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;
}

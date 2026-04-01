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
@Table(name = "song_requests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SongRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer songRequestId;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "song_name")
    private String songName;

    @Column(name = "artist")
    private String artist;

    @Column(name = "spotify_link")
    private String spotifyLink;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}

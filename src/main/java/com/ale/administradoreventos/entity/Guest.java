package com.ale.administradoreventos.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "guests")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer guestId;

    @ManyToOne
    @JoinColumn(name = "event_id",nullable = false)
    private Event event;

    @Column(name = "guest_name", nullable = false, length = 250)
    @Size(min = 3, max = 250, message = "El nombre del invitado debe tener 3-250 caracteres")
    @NotBlank
    private String guestName;

    @Column(name = "guest_lastname", nullable = false, length = 250)
    @Size(min = 3, max = 250, message = "El apellido del invitado debe tener 3-250 caracteres")
    @NotBlank
    private String guestLastname;

    @Column(name = "guest_email")
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "Escriba una dirección de correo válida (ejemplo: usuario@dominio.com)")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "El correo debe tener un formato válido (ejemplo: usuario@dominio.com)"
    )
    private String guestEmail;

    @Column(name = "guest_will_attend")
    @NotNull
    private Boolean guestWillAttend;

    @Column(name = "guest_allergies")
    private  String guestAllergies;

    @Column(name = "guest_comments")
    @Size(min = 1, max = 250, message = "El comentario debe tener 1-250 caracteres")
    private String guestComments;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

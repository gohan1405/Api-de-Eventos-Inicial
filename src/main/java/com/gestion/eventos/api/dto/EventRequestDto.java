package com.gestion.eventos.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Schema(description = "detalles de la solicitud para crear/actualizar un evento")
public class EventRequestDto {
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate date;
    @NotBlank(message = "La ubicacion no puede estar vacia")
    private String location;

    @NotNull(message = "La categoria es obligatoria")
    private Long categoryId;

    @NotNull(message = "Debe ser obligatoria")
    private Set<Long> speakersId;
}

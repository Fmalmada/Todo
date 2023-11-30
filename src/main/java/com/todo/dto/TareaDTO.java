package com.todo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TareaDTO {
    private Long id;

    private String descripcion;
    
    private LocalDate fechaCreacion;
    private Boolean finalizada;
}

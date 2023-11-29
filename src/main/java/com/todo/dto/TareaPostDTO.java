package com.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class TareaPostDTO {
    @NotNull(message = "Por favor ingrese una descripción")
    @NotBlank(message = "Por favor ingrese una descripción")
    private String descripcion;
}

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
public class UsuarioPostDTO {

    @NotNull(message = "Por favor ingrese un nombre de usuario")
    @NotBlank(message = "Por favor ingrese un nombre de usuario")
    private String username;

    @NotNull(message = "Por favor ingrese una contraseña")
    @NotBlank(message = "Por favor ingrese una contraseña")
    private String password;
    
    @NotNull(message = "Por favor ingrese una contraseña")
    @NotBlank(message = "Por favor ingrese una contraseña")
    private String confirmar;
    
}

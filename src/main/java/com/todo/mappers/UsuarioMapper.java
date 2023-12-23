package com.todo.mappers;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.todo.dto.UsuarioPostDTO;
import com.todo.modelo.Usuario;

public interface UsuarioMapper {

    Usuario map(UsuarioPostDTO usuarioPost, PasswordEncoder encoder);
    
}

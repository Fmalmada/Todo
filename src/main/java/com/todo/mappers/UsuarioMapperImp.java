package com.todo.mappers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.todo.dto.UsuarioPostDTO;
import com.todo.modelo.Usuario;

@Component
public class UsuarioMapperImp implements UsuarioMapper {

    @Override
    public Usuario map(UsuarioPostDTO usuarioPost, PasswordEncoder encoder) {
       return Usuario.builder()
                                .username(usuarioPost.getUsername())
                                .password(encoder.encode(usuarioPost.getPassword()))
                                .build();
    }
    
}

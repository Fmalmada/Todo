package com.todo.service;

import com.todo.dto.UsuarioPostDTO;


public interface RegistroService {
    
   public UsuarioPostDTO crearUsuario(UsuarioPostDTO usuarioPost);

   public boolean existeUsuario(UsuarioPostDTO usuarioPostDTO);

}

package com.todo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo.dto.UsuarioPostDTO;
import com.todo.mappers.UsuarioMapperImp;
import com.todo.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistroServiceImp implements RegistroService {

    private final UsuarioRepository userRepo;
   

    private final PasswordEncoder passwordEncoder;

    private final UsuarioMapperImp userMapper;

    @Override
    public UsuarioPostDTO crearUsuario(UsuarioPostDTO usuarioPost) {
        userRepo.save(userMapper.map(usuarioPost, passwordEncoder));
        return usuarioPost;
    }

    @Override
    public boolean existeUsuario(UsuarioPostDTO usuarioPostDTO) {
       return userRepo.existsByUsername(usuarioPostDTO.getUsername());
    }
    
}

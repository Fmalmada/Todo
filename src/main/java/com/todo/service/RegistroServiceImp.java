package com.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.todo.dto.UsuarioPostDTO;
import com.todo.mappers.UsuarioMapperImp;
import com.todo.repository.UsuarioRepository;

@Service
public class RegistroServiceImp implements RegistroService {

    @Autowired
    private UsuarioRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioMapperImp userMapper;

    @Override
    public UsuarioPostDTO crearUsuario(UsuarioPostDTO usuarioPost) {
        userRepo.save(userMapper.map(usuarioPost, passwordEncoder));
        return usuarioPost;
    }
    
}

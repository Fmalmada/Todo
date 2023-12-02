package com.todo.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo.excepciones.NotFoundException;
import com.todo.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UsuarioRepository usuariosRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       return usuariosRepo.findByUsername(username).orElseThrow(NotFoundException::new);
    }
}
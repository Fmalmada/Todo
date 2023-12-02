package com.todo.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.todo.modelo.Tarea;
import com.todo.modelo.Usuario;
import com.todo.repository.TareaRepository;
import com.todo.repository.UsuarioRepository;

@Configuration
public class TareasConfig {

    @Bean
    CommandLineRunner inicializarBaseDeDatos(TareaRepository tareasRepo, UsuarioRepository usuariosRepo, PasswordEncoder passwordEncoder) {
        return args -> {
           Tarea tareaEjemplo = Tarea.builder()
                                        .descripcion("primer ejemplo")
                                        .build();

            Tarea otraTareaEjemplo = Tarea.builder()
                                            .descripcion("otra tarea de ejemplo")
                                            .build();
            
            tareasRepo.saveAll(Arrays.asList(tareaEjemplo, otraTareaEjemplo));

            usuariosRepo.save(Usuario.builder()
                .username("usuario")
                .password(passwordEncoder.encode("123"))
                .build());

                usuariosRepo.save(Usuario.builder()
                .username("prueba")
                .password(passwordEncoder.encode("abc"))
                .build());
        };
    }
    
}

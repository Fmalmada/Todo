package com.todo.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.todo.modelo.Tarea;
import com.todo.repository.TareaRepository;

@Configuration
public class TareasConfig {

    @Bean
    CommandLineRunner inicializarBaseDeDatos(TareaRepository tareasRepo) {
        return args -> {
           Tarea tareaEjemplo = Tarea.builder()
                                        .descripcion("primer ejemplo")
                                        .build();

            Tarea otraTareaEjemplo = Tarea.builder()
                                            .descripcion("otra tarea de ejemplo")
                                            .build();
            
            tareasRepo.saveAll(Arrays.asList(tareaEjemplo, otraTareaEjemplo));

        };
    }
    
}

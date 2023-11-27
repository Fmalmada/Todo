package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.modelo.Tarea;

public interface TareaRepository extends JpaRepository<Tarea,Long> {
    
}

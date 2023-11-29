package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.modelo.Tarea;

import jakarta.transaction.Transactional;

public interface TareaRepository extends JpaRepository<Tarea,Long> {

    @Transactional
    public void deleteByFinalizada(Boolean finalizada);
    
}

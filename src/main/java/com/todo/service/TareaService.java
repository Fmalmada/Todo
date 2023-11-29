package com.todo.service;

import java.util.List;

import com.todo.dto.TareaDTO;
import com.todo.dto.TareaPostDTO;

public interface TareaService {
    
    public TareaDTO postTarea(TareaPostDTO tarea);

    public TareaDTO getTarea(Long id);

    public List<TareaDTO> getTareas();

    public void deleteTarea(Long id);

    public TareaDTO putTarea(Long id, TareaPostDTO tarea);

    public TareaDTO finalizarTarea(Long id);

    public void deleteFinalizadas();
}

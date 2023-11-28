package com.todo.service;

import java.util.List;

import com.todo.dto.TareaDTO;
import com.todo.dto.TareaPostDTO;

public interface TareaService {
    
    public TareaDTO postTarea(TareaPostDTO tarea);

    public TareaDTO getTarea(Long id);

    public List<TareaDTO> getTareas();
    
}

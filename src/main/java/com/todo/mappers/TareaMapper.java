package com.todo.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.todo.dto.TareaDTO;
import com.todo.modelo.Tarea;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    TareaDTO map(Tarea tarea);
    List<TareaDTO> map(List<Tarea> tareas);
    
}

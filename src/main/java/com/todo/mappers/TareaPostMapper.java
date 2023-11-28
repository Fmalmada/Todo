package com.todo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.todo.dto.TareaPostDTO;
import com.todo.modelo.Tarea;

@Mapper(componentModel = "spring")
public interface TareaPostMapper {

    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "finalizada", ignore = true)
    @Mapping(target = "id", ignore = true)
    Tarea map(TareaPostDTO tareaPost);
    
}

package com.todo.mappers;

import org.mapstruct.Mapper;

import com.todo.dto.TareaPostDTO;
import com.todo.modelo.Tarea;

@Mapper(componentModel = "spring")
public interface TareaPostMapper {

    Tarea map(TareaPostDTO tareaPost);
    
}

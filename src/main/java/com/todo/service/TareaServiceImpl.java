package com.todo.service;

import org.springframework.stereotype.Service;

import com.todo.dto.TareaDTO;
import com.todo.dto.TareaPostDTO;
import com.todo.mappers.TareaMapper;
import com.todo.mappers.TareaPostMapper;
import com.todo.repository.TareaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareasRepo;
    private final TareaMapper tareasMapper;
    private final TareaPostMapper tareasPostMapper;

    public TareaDTO postTarea(TareaPostDTO tarea) {
        return tareasMapper.map(
            tareasRepo.save(tareasPostMapper.map(tarea))
        );
    }
    
}

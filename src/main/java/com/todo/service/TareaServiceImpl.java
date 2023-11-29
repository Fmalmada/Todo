package com.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.dto.TareaDTO;
import com.todo.dto.TareaPostDTO;
import com.todo.excepciones.NotFoundException;
import com.todo.mappers.TareaMapper;
import com.todo.mappers.TareaPostMapper;
import com.todo.modelo.Tarea;
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

    public TareaDTO getTarea(Long id) {
        return tareasMapper.map(
            tareasRepo.findById(id).orElseThrow(NotFoundException::new)
        );
    }

    public List<TareaDTO> getTareas() {
        return tareasMapper.map(
            tareasRepo.findAll()
        );
    }

    public void deleteTarea(Long id) {
        if (!tareasRepo.existsById(id)) {
            throw new RuntimeException();
        }

        tareasRepo.deleteById(id);
    }


    public TareaDTO putTarea(Long id, TareaPostDTO tareaPost) {
        if (!tareasRepo.existsById(id)) {
            throw new RuntimeException();
        }

        Tarea tareaNueva = tareasPostMapper.map(tareaPost);
        tareaNueva.setId(id);

        return tareasMapper.map(
            tareasRepo.save(tareaNueva)
        );
    }
        
    
}

package com.todo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.todo.dto.TareaDTO;
import com.todo.dto.TareaPostDTO;
import com.todo.mappers.TareaMapper;
import com.todo.mappers.TareaPostMapper;
import com.todo.modelo.Tarea;
import com.todo.repository.TareaRepository;

@ExtendWith(MockitoExtension.class)
public class TareaServiceTest {

    @Mock
	@Autowired
    private TareaRepository tareasRepo;

    @Mock
	@Autowired
    private TareaMapper tareasMapper;

    @Mock
	@Autowired
    private TareaPostMapper tareasPostMapper;

    @InjectMocks
    private TareaServiceImpl tareaService;

    private Tarea tarea;
    private TareaDTO tareaDTO;
    private TareaPostDTO tareaPostDTO;

    private List<TareaDTO> listaTareasDTO;

    private Long idPrueba;



    @BeforeEach
	void setUp() {
        idPrueba = Long.valueOf(1);

		tarea = Tarea.builder()
                    .descripcion("Tarea de ejemplo")
				    .id(idPrueba)
				    .build();
		
		tareaDTO = TareaDTO.builder()
							.descripcion(tarea.getDescripcion())
                            .id(tarea.getId())
                            .build();
		
		tareaPostDTO = TareaPostDTO.builder()
                                    .descripcion(tarea.getDescripcion())
						            .build();
		
		listaTareasDTO = Arrays.asList(tareaDTO);
	}

    @Test
    public void testPostTarea(){
        when(tareasPostMapper.map(tareaPostDTO)).thenReturn(tarea);
        when(tareasRepo.save(tarea)).thenReturn(tarea);
        when(tareasMapper.map(tarea)).thenReturn(tareaDTO);

        assertEquals(tareaService.postTarea(tareaPostDTO), tareaDTO);

        verify(tareasPostMapper, times(1)).map(tareaPostDTO);
        verify(tareasRepo, times(1)).save(tarea);
        verify(tareasMapper, times(1)).map(tarea);
    }
    
}
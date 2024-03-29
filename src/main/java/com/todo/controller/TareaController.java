package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.dto.TareaDTO;
import com.todo.dto.TareaPostDTO;
import com.todo.service.TareaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService tareaService;

    @GetMapping
    public String getTareas(Model unModelo) {
        unModelo.addAttribute("tareas", tareaService.getTareas());
        return "home";
    }

    @GetMapping("/nuevaTarea")
    public String getNuevaTareaForm(Model unModelo) {
        TareaPostDTO tareaPostDTO = new TareaPostDTO();
        unModelo.addAttribute("tarea", tareaPostDTO);
        return "tareaForm";
    }

    @PostMapping("/nuevaTarea")
    public String postTarea(@Valid @ModelAttribute("tarea") TareaPostDTO tareaPostDTO, BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "tareaForm";
        }

        tareaService.postTarea(tareaPostDTO);
        return "redirect:/tareas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(Model unModelo, @PathVariable Long id) {
        tareaService.deleteTarea(id);
        return "redirect:/tareas";
    }

    @GetMapping("/editar/{id}")
    public String editarTareaForm(Model unModelo, @PathVariable Long id) {
        TareaDTO tareaEditar = tareaService.getTarea(id);
        unModelo.addAttribute("tarea", tareaEditar);
        return "tareaEditarForm";
    }

    @PostMapping("/editar/{id}")
    public String editarTarea(@Valid @ModelAttribute("tarea") TareaPostDTO tareaPostDTO, BindingResult resultado, @PathVariable Long id) {
        if (resultado.hasErrors()) {
            return "tareaEditarForm";
        }

        tareaService.putTarea(id, tareaPostDTO);
        return "redirect:/tareas";
    }

    @GetMapping("/finalizar/{id}")
    public String finalizarTarea(@PathVariable Long id) {
        tareaService.finalizarTarea(id);
        return "redirect:/tareas";

    }

    @GetMapping("/eliminarTareas")
    public String eliminarTareas() {
        tareaService.deleteFinalizadas();
        return "redirect:/tareas";
    }
}

package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.service.TareaService;

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
}

package com.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.todo.dto.UsuarioPostDTO;
import com.todo.service.RegistroService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tareas")
public class RegistroController {

    private final RegistroService registroService;

    @GetMapping("/registro")
    public String getRegistro(Model modelo) {
        modelo.addAttribute("usuario", new UsuarioPostDTO());
        modelo.addAttribute("noIgual", false);
        modelo.addAttribute("existeUsuario", false);
        return "registro";
    }

    @PostMapping("/registro")
    public String postRegistro(@Valid @ModelAttribute("usuario") UsuarioPostDTO usuarioPostDTO, BindingResult resultado, Model modelo) {
        if (resultado.hasErrors()) {
            return "registro";
        }

        if(registroService.existeUsuario(usuarioPostDTO)){
            modelo.addAttribute("existeUsuario", true);
            return "registro";
        }

        if (!usuarioPostDTO.getConfirmar().equals(usuarioPostDTO.getPassword())) {
            modelo.addAttribute("noIgual", true);
            return "registro";
        }
        registroService.crearUsuario(usuarioPostDTO);
        return "login";
    }
    
}

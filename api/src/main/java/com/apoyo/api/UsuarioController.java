package com.apoyo.api;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios() {
        return repository.findAll();
    }
}
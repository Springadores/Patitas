package com.ada.patitas.projetopatitas.controller;


import com.ada.patitas.projetopatitas.model.Veterinario;
import com.ada.patitas.projetopatitas.service.VeterinarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {
    @Autowired
    private VeterinarioService veterinarioService;


    @GetMapping
    public ResponseEntity<List<Veterinario>> buscarTodosVeterinarios() {
        List<Veterinario> veterinarios = veterinarioService.buscarTodosVeterinarios();
        return new ResponseEntity<>(veterinarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarVeterinarioPorId(@PathVariable Long id) {
        Optional<Veterinario> veterinarioOptional = veterinarioService.buscarVeterinarioPorId(id);
        return veterinarioOptional.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping
    public ResponseEntity<Veterinario> cadastrarVeterinario(@RequestBody Veterinario veterinario) {
        Veterinario novo = veterinarioService.cadastrarVeterinario(veterinario);
        return new ResponseEntity<>(novo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarVeterinario(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        veterinarioService.atualizarVeterinario(id, veterinario);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarVeterinario(@PathVariable Long id) {
        veterinarioService.deletarVeterinario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

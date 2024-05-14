package br.com.ada.patitas.controller;


import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.model.Veterinario;
import br.com.ada.patitas.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;


import java.util.List;

import java.util.Optional;

import static br.com.ada.patitas.mapper.ConsultaMapper.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<ConsultaDto>> findAll() {
        List<Consulta> consultas = consultaService.findAll();
        return ResponseEntity.ok(toDtoConsulta(consultas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaDto> findById(@PathVariable("id") final Long id) {
        final Optional<Consulta> consultaOptional = consultaService.findById(id);
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toDtoConsultaDto(consultaOptional.get()));

    }

    @PostMapping
    public ResponseEntity<Consulta> save(@Valid @RequestBody final ConsultaDto consultaDto, BindingResult result) {
        consultaService.save(toEntityConsulta(consultaDto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaDto> update(@PathVariable("id") final Long id, final ConsultaDto consultaDto) {
        final Optional<Consulta> consultaOptional = consultaService.update(id, toEntityConsulta(consultaDto));
        if (consultaOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(consultaDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        consultaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

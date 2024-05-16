package br.com.ada.patitas.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.ada.patitas.dto.ConsultaDto;
import br.com.ada.patitas.model.Consulta;
import br.com.ada.patitas.service.ConsultaService;

public class ConsultaControllerTest {

    @Mock
    private ConsultaService consultaService;

    @InjectMocks
    private ConsultaController consultaController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        // Given
        Consulta consulta1 = new Consulta();
        Consulta consulta2 = new Consulta();
        List<Consulta> consultas = Arrays.asList(consulta1, consulta2);

        // When
        when(consultaService.findAll()).thenReturn(consultas);

        // Then
        ResponseEntity<List<ConsultaDto>> response = consultaController.findAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testFindById() {
        // Given
        Consulta consulta = new Consulta();
        consulta.setId(1L);

        // When
        when(consultaService.findById(anyLong())).thenReturn(Optional.of(consulta));

        // Then
        ResponseEntity<ConsultaDto> response = consultaController.findById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    public void testSave() {
        // Given
        ConsultaDto consultaDto = new ConsultaDto();

        // Then
        ResponseEntity<Consulta> response = consultaController.save(consultaDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(consultaService, times(1)).save(any());
    }

    @Test
    public void testUpdate() {
        // Given
        ConsultaDto consultaDto = new ConsultaDto();
        consultaDto.setId(1L);

        // When
        when(consultaService.update(anyLong(), any())).thenReturn(Optional.of(new Consulta()));

        // Then
        ResponseEntity<ConsultaDto> response = consultaController.update(1L, consultaDto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody().getId());
    }

    @Test
    public void testDelete() throws Exception {
        // Then
        ResponseEntity<Void> response = consultaController.delete(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(consultaService, times(1)).delete(anyLong());
    }
}
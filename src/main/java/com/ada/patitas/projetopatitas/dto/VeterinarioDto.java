package com.ada.patitas.projetopatitas.dto;



import com.ada.patitas.projetopatitas.model.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarioDto {

    private Long id;

    @NotBlank(message = "O Atributo nome é obrigatório")
    private String nome;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Especialidade especialidade;

    @ElementCollection
    private List<String> horariosDisponiveis;

}

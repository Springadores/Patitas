package br.com.ada.patitas.mapper;


import br.com.ada.patitas.dto.VeterinarioDto;
import br.com.ada.patitas.model.Veterinario;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class VeterinarioMapper {
    public static List<VeterinarioDto> toDtoVeterinario(final List<Veterinario> entities) {

        return entities.stream()
                .map(VeterinarioMapper::toDtoVeterinarioDto)
                .collect(Collectors.toList());
    }

    public static VeterinarioDto toDtoVeterinarioDto(final Veterinario entity) {
        if (Objects.nonNull(entity)) {
            return VeterinarioDto.builder()
                    .nome(entity.getNome())
                    .especialidade(entity.getEspecialidade())
                    .horariosDisponiveis(entity.getHorariosDisponiveis())
                    .build();
        } else {
            return VeterinarioDto.builder().build();
        }
    }

    public static Veterinario toEntityVeterinario(final VeterinarioDto dto) {
        return Veterinario.builder()
                .nome(dto.getNome())
                .especialidade(dto.getEspecialidade())
                .horariosDisponiveis(dto.getHorariosDisponiveis())
                .build();
    }

}

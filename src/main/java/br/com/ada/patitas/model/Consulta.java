package br.com.ada.patitas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "veterinario_id")
    private Long idVeterinario;

    @Column(name = "paciente_id")
    private Long idPaciente;


    @Column(name = "horarios_disponiveis_id")
    private Long idHorariosDisponiveis;

    @Column(name = "motivo_da_consulta")
    private String motivoDaConsulta;
}

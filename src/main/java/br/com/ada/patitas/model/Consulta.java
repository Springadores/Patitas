package br.com.ada.patitas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Date;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "servico")
    private Servico servico;

    @Column(name = "tipo_servico")
    private String tipoServico;

    @Column(name = "preco")
    private Double preco;
    @Column(name = "status")
    private boolean status;

}

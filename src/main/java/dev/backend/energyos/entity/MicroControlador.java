package dev.backend.energyos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "micro_controlador")
public class MicroControlador {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID idEsp32;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="modulo_leitor_id")
    private ModuloLeitor moduloLeitor;

    private LocalDateTime dataSaidaManutencao;

    private LocalDateTime dataTrocado;

    private LocalDateTime dataRetornoManutencao;
}

package dev.backend.energyos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "microControlador")
public class MicroControlador {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID idEsp32;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuarioPertence;

    @OneToOne
    @JoinColumn(name="moduloLeitor")
    private ModuloLeitor moduloLeitor;

    private LocalDateTime dataSaidaManutencao;

    private LocalDateTime dataTrocado;

    private LocalDateTime dataRetornoManutencao;
}

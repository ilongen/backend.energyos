package dev.backend.energyos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Table(name="modulo_leitor")
@Entity
@Getter
@Setter
public class ModuloLeitor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idModuloLeitor;

    @OneToOne(mappedBy = "moduloLeitor")
    private MicroControlador microControlador;

    private String nome;

    private LocalDateTime dataSaidaManutencao;

    private LocalDateTime dataTroca;

    private LocalDateTime dataRetornoManutencao;
}

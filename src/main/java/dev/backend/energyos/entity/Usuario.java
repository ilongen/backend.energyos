package dev.backend.energyos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name="usuario")
@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUsuario;

    private String nome;

    private String numeroCasa;

    private String cep;

    @OneToMany(mappedBy = "usuario")
    private List<MicroControlador> microControladores;
}

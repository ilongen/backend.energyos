package dev.backend.energyos.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UsuarioRequest {
    private UUID idUsuario;
    private String nome;
    private String numeroCasa;
    private String cep;
}

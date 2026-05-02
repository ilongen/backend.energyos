package dev.backend.energyos.repository;

import dev.backend.energyos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepo extends JpaRepository<Usuario, UUID> {
    Usuario findByEmail(String email);
}

package com.atered.forumhub.repository;

import com.atered.forumhub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Boolean existsByEmail(@Valid @NotBlank String email);

    UserDetails findByEmail(String email);
}

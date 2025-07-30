package com.atered.forumhub.repository;

import com.atered.forumhub.domain.curso.Curso;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Boolean existsByNome(@NotBlank(message = "Nome do curso é obrigatório") String nome);
}

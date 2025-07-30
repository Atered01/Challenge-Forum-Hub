package com.atered.forumhub.repository;

import com.atered.forumhub.domain.topico.Topico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Boolean existsByTituloAndMensagem(@NotBlank(message = "Titulo é obrigatório") String titulo, @NotBlank(message = "Mensagem é obrigatória") String mensagem);

    boolean existsByTituloAndMensagemAndIdNot(@NotBlank String titulo, @NotBlank String mensagem, Long id);
}

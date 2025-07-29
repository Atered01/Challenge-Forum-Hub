package com.atered.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroTopico(@NotBlank(message = "Titulo é obrigatório")String titulo,
                                  @NotBlank(message = "Mensagem é obrigatória") String mensagem,
                                  @NotNull LocalDateTime data,
                                  Estado estado) {
}

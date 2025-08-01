package com.atered.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(@NotBlank String titulo,
                                   @NotBlank String mensagem,
                                   @NotNull Estado estado) {
}

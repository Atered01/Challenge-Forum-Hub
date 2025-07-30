package com.atered.forumhub.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUsario(@NotNull Long id, String nome, String senha) {
}

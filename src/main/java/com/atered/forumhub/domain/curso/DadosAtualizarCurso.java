package com.atered.forumhub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarCurso(@NotNull Long id, String nome, Categoria categoria) {
}

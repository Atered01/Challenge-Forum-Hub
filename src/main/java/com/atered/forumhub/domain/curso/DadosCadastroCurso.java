package com.atered.forumhub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(@NotBlank(message = "Nome do curso é obrigatório") String nome,
                                 @NotNull(message = "Categoria do curso é obrigatória") Categoria categoria) {
}

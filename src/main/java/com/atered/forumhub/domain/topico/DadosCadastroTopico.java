package com.atered.forumhub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(@NotBlank(message = "Titulo é obrigatório")String titulo,
                                  @NotBlank(message = "Mensagem é obrigatória") String mensagem,
                                  @NotNull(message = "O ID do curso é obrigatório") Long cursoId){}

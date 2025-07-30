package com.atered.forumhub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DadosListagemCurso (@NotNull Long id, String nome, Categoria categoria) {
    public DadosListagemCurso(Curso curso){
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}

package com.atered.forumhub.domain.usuario;

import jakarta.validation.constraints.NotNull;

public record DadosListagemUsuario(Long id, String nome, String email) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}

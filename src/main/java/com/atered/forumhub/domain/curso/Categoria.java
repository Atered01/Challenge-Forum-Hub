package com.atered.forumhub.domain.curso;

import com.atered.forumhub.domain.topico.Estado;

import java.util.Arrays;

public enum Categoria {
    PROGRAMACAO("Programação"),
    FRONT_END("Front End"),
    DATA_SCIENCE("Data Science"),
    INTELIGENCIA_ARTIFICIAL("Inteligência Artificial"),
    DEVOPS("DevOps"),
    UX_E_DESIGN("UX & Design"),
    MOBILE("Mobile"),
    INOVACAO_E_GESTAO("Inovação & Gestão");

    private String categoria;

    Categoria(String categoria) {
        this.categoria = categoria;
    }
    public static Categoria fromEstado(String text) {
        return Arrays.stream(Categoria.values())
                .filter(c -> c.categoria.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhuma categoria encontrado"));
    }
}

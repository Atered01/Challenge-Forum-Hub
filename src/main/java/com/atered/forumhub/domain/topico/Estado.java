package com.atered.forumhub.domain.topico;

import java.util.Arrays;

public enum Estado {
    NAO_RESPONDIDO("Não respondido"),
    EM_DISCUSSAO("Em discussão"),
    SOLUCIONADO("Solucionado");

    private String estado;

    Estado(String estado) {
        this.estado = estado;
    }

    public static Estado fromEstado(String text) {
        return Arrays.stream(Estado.values())
                .filter(e -> e.estado.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Nenhum Estado encontrado"));
    }
}

package com.atered.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico (Long id, String titulo, String mensagem, LocalDateTime data, Estado estado) {
    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getData(), topico.getEstado());
    }
}

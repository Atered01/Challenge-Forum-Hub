package com.atered.forumhub.domain.topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico(Long id, Long idUsuario, Long idCurso, LocalDateTime data, String nomeAutor, String nomeCurso) {
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getUsuario().getId(), topico.getCurso().getId(), topico.getData(), topico.getUsuario().getNome(), topico.getCurso().getNome());
    }
}
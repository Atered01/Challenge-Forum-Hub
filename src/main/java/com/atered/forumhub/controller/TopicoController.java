package com.atered.forumhub.controller;

import com.atered.forumhub.domain.topico.*;
import com.atered.forumhub.repository.CursoRepository;
import com.atered.forumhub.repository.TopicosRepository;
import com.atered.forumhub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicosRepository topicosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder) {
        if (topicosRepository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())){
            throw new IllegalArgumentException("Tópico duplicado.");
        }
        var autor = usuarioRepository.findById(dados.autorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado."));
        var curso = cursoRepository.findById(dados.cursoId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado."));

        var topico = new Topico(dados, autor, curso);
        topicosRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }
}
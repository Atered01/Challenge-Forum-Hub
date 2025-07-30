package com.atered.forumhub.controller;

import com.atered.forumhub.domain.curso.Curso;
import com.atered.forumhub.domain.curso.DadosCadastroCurso;
import com.atered.forumhub.domain.curso.DadosDetalhamentoCurso;
import com.atered.forumhub.repository.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroCurso dados, UriComponentsBuilder uriBuilder) {
        if(cursoRepository.existsByNome(dados.nome())){
            throw new IllegalArgumentException("Nome de curso já cadastrado");
        }
        var curso = new Curso(dados);
        cursoRepository.save(curso);
        var uri = uriBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }
}

package com.atered.forumhub.controller;

import com.atered.forumhub.domain.curso.*;
import com.atered.forumhub.repository.CursoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroCurso dados, UriComponentsBuilder uriBuilder) {
        if (cursoRepository.existsByNome(dados.nome())) {
            throw new IllegalArgumentException("Curso já cadastrado");
        }
        var curso = new Curso(dados);
        cursoRepository.save(curso);
        var uri = uriBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCurso>> listarCursos(@PageableDefault(size = 10, sort = {"nome"}) Pageable pegeable) {
        var page = cursoRepository.findAll(pegeable).map(DadosListagemCurso::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity detalharCurso(@PathVariable Long id) {
        var curso = cursoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity atualizarCurso (@PathVariable Long id,  @RequestBody @Valid DadosAtualizarCurso dados) {
        var curso = cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
        if (cursoRepository.existsByNomeAndIdNot(dados.nome(), id)) {
            throw new IllegalArgumentException("Já existe curso com esse nome");
        }
        curso.atualizarCurso(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCurso(curso));
    }
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deletarCurso(@PathVariable Long id) {
        if(!cursoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cursoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

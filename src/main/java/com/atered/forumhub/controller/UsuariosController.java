package com.atered.forumhub.controller;

import com.atered.forumhub.domain.usuario.*;
import com.atered.forumhub.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        if (usuarioRepository.existsByEmail(dados.email())){
            throw new IllegalArgumentException("Email ja cadastrado");
        }
        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listarUsuarios(@PageableDefault(size = 10, sort = {"nome"}) Pageable pageable) {
        var page = usuarioRepository.findAll(pageable).map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("{id}")
    public ResponseEntity detalharUsuario(@PathVariable Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity atualizarUsuario(@PathVariable Long id, @Valid @RequestBody DadosAtualizarUsario dados){
        var usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
        usuario.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity deleteUsuario(@PathVariable Long id){
        if(!usuarioRepository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

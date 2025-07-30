package com.atered.forumhub.controller;

import com.atered.forumhub.domain.usuario.DadosCadastroUsuario;
import com.atered.forumhub.domain.usuario.DadosDetalhamentoUsuario;
import com.atered.forumhub.domain.usuario.Usuario;
import com.atered.forumhub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity cadastrar(@Valid @RequestBody DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
        if (usuarioRepository.existsByEmail(dados.email())){
            throw new IllegalArgumentException("Email ja cadastrado");
        }
        var usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

}

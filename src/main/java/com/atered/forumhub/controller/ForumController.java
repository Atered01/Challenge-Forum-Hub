package com.atered.forumhub.controller;

import com.atered.forumhub.domain.usuario.Usuario;
import com.atered.forumhub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseEntity cadastrarTopico(@RequestBody) {}
}

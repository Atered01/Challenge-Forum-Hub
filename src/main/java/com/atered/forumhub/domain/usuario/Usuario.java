package com.atered.forumhub.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "usuarios")
@Entity(name = "Usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void atualizarInformacoes(@Valid DadosAtualizarUsario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
    }
}

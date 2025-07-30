package com.atered.forumhub.domain.topico;

import com.atered.forumhub.domain.curso.Curso;
import com.atered.forumhub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    public Topico(DadosCadastroTopico dados, Usuario usuario, Curso curso) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.curso = curso;
        this.usuario = usuario;
        this.data = LocalDateTime.now();
        this.estado = Estado.NAO_RESPONDIDO;
    }

}

package com.atered.forumhub.domain.curso;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DadosCadastroCurso dados){
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

    public void atualizarCurso(DadosAtualizarCurso dados){
        this.nome = dados.nome();
        this.categoria = dados.categoria();
    }

}

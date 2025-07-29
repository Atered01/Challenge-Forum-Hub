package com.atered.forumhub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(@NotBlank(message = "Nome é obrigatório")String nome,
                                   @NotBlank(message = "Email é obrigatório") @Email(message = "Formato do email invalido")String email,
                                   @NotBlank(message = "Senha é obrigatória") String senha ) {
}

package com.api.odontocloud.adapters.inbound.dto.auth;
import com.api.odontocloud.application.core.domain.UsuarioRole;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(

    @NotBlank(message = "O campo login é obrigatório!")
    String login,
    @NotBlank(message = "O campo password é obrigatório!")
    String password,
    @NotBlank(message = "O campo nome é obrigatório!")
    String nome,
    @NotBlank(message = "O campo sobrenome é obrigatório!")
    String sobrenome,
    @NotBlank(message = "O campo telefone é obrigatório!")
    String telefone,
    UsuarioRole usuarioRole) {
}

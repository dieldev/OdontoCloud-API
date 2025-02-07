package com.api.odontocloud.adapters.inbound.dto.auth;
import com.api.odontocloud.application.core.domain.UsuarioRole;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

    @NotNull(message = "O campo usuarioRole é obrigatório!") @Valid UsuarioRole usuarioRole,

    String cro
) {
}

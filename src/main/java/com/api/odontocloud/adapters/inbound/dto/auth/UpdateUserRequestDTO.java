package com.api.odontocloud.adapters.inbound.dto.auth;

import com.api.odontocloud.application.core.domain.UsuarioRole;

public record UpdateUserRequestDTO(

        String login,
        String password,
        String nome,
        String sobrenome,
        String telefone,
        UsuarioRole usuarioRole,
        String cro

) {
}

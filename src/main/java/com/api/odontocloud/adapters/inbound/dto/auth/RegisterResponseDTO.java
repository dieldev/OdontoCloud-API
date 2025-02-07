package com.api.odontocloud.adapters.inbound.dto.auth;

import com.api.odontocloud.application.core.domain.DetalhesUsuario;
import com.api.odontocloud.application.core.domain.UsuarioRole;

public record RegisterResponseDTO(
        Integer id,
        String nome,
        String sobrenome,
        String telefone,
        String login,
        String password,
        boolean ativo,
        UsuarioRole usuarioRole,
        DetalhesUsuario detalhesUsuario) {
}

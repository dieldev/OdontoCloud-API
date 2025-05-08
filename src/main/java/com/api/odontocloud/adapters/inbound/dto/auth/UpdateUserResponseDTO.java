package com.api.odontocloud.adapters.inbound.dto.auth;

import com.api.odontocloud.application.core.domain.UsuarioRole;

public record UpdateUserResponseDTO(
        Integer id,
        String nome,
       String sobrenome,
       String telefone,
       String login,
       String password,
       boolean ativo,
       UsuarioRole usuarioRole,
       UpdateRespondeDetalhesDTO detalhesUsuario) {
}

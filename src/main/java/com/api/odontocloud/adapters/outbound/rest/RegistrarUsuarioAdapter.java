package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.ports.out.RegistrarUsuarioOutputPort;
import org.springframework.stereotype.Component;

@Component
public class RegistrarUsuarioAdapter implements RegistrarUsuarioOutputPort {

    private final UsuarioMapper usuarioMapper;

    public RegistrarUsuarioAdapter(UsuarioMapper usuarioMapper) {
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public RegisterResponseDTO execute(Usuario novoUsuario) {
        return usuarioMapper.fromUsuariotoDtoRegisterResponse(novoUsuario);
    }
}

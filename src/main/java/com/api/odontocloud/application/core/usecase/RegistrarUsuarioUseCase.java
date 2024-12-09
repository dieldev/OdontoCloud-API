package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.ports.in.RegistrarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.RegistrarUsuarioOutputPort;

public class RegistrarUsuarioUseCase implements RegistrarUsuarioInputPort {

    private final RegistrarUsuarioOutputPort registrarUsuarioOutputPort;

    public RegistrarUsuarioUseCase(RegistrarUsuarioOutputPort registrarUsuarioOutputPort) {
        this.registrarUsuarioOutputPort = registrarUsuarioOutputPort;
    }

    @Override
    public RegisterResponseDTO execute(Usuario usuario) {
        return registrarUsuarioOutputPort.execute(usuario);
    }
}

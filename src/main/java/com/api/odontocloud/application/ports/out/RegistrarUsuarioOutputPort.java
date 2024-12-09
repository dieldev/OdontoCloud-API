package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;

public interface RegistrarUsuarioOutputPort {
    RegisterResponseDTO execute(Usuario usuario);
}

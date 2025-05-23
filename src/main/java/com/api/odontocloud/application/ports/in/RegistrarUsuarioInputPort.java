package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;

public interface RegistrarUsuarioInputPort {

    RegisterResponseDTO execute(Usuario usuario);
}

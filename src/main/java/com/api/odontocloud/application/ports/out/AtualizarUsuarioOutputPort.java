package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.adapters.inbound.dto.auth.UpdateUserResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;

public interface AtualizarUsuarioOutputPort {

    UpdateUserResponseDTO execute(Usuario usuario, Long id);
}

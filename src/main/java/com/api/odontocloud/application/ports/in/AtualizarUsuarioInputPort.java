package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.auth.UpdateUserResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;

public interface AtualizarUsuarioInputPort {

    UpdateUserResponseDTO execute(Usuario usuario, Long id);
}

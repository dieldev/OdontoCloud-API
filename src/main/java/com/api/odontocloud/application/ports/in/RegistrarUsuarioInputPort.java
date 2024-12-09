package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface RegistrarUsuarioInputPort {

    RegisterResponseDTO execute(Usuario usuario);
}

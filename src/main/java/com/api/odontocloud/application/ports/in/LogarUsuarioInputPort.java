package com.api.odontocloud.application.ports.in;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.LoginResponseDTO;

public interface LogarUsuarioInputPort {

    LoginResponseDTO execute(LoginRequestDTO loginRequestDTO);
}

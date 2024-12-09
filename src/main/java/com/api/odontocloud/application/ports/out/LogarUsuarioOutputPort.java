package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.LoginResponseDTO;

public interface LogarUsuarioOutputPort {

    LoginResponseDTO execute(LoginRequestDTO loginRequestDTO);

}

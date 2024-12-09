package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.LoginResponseDTO;
import com.api.odontocloud.application.ports.in.LogarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.LogarUsuarioOutputPort;

public class LogarUsuarioUseCase implements LogarUsuarioInputPort {

    private final LogarUsuarioOutputPort logarUsuarioOutputPort;

    public LogarUsuarioUseCase(LogarUsuarioOutputPort logarUsuarioOutputPort) {
        this.logarUsuarioOutputPort = logarUsuarioOutputPort;
    }

    @Override
    public LoginResponseDTO execute(LoginRequestDTO loginRequestDTO) {
        return logarUsuarioOutputPort.execute(loginRequestDTO);
    }
}

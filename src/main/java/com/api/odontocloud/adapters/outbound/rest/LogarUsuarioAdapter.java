package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginResponseDTO;
import com.api.odontocloud.application.ports.out.LogarUsuarioOutputPort;
import org.springframework.stereotype.Component;

@Component
public class LogarUsuarioAdapter implements LogarUsuarioOutputPort {

    @Override
    public LoginResponseDTO execute(String tokenJWT) {
        return new LoginResponseDTO(tokenJWT);
    }
}
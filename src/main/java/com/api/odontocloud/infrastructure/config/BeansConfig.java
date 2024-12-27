package com.api.odontocloud.infrastructure.config;

import com.api.odontocloud.adapters.outbound.rest.LogarUsuarioAdapter;
import com.api.odontocloud.adapters.outbound.rest.RegistrarUsuarioAdapter;
import com.api.odontocloud.application.core.usecase.LogarUsuarioUseCase;
import com.api.odontocloud.application.core.usecase.RegistrarUsuarioUseCase;
import com.api.odontocloud.application.ports.in.LogarUsuarioInputPort;
import com.api.odontocloud.application.ports.in.RegistrarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public RegistrarUsuarioInputPort registrarUsuarioImpl(RegistrarUsuarioOutputPort registrarUsuarioOutputPort, VerificarUsuarioOutputPort verificarUsuarioOutputPort, SalvarUsuarioOutputPort salvarUsuarioOutputPort, CriptografarSenhaOutputPort criptografarSenhaOutputPort) {
        return new RegistrarUsuarioUseCase(registrarUsuarioOutputPort, verificarUsuarioOutputPort, salvarUsuarioOutputPort, criptografarSenhaOutputPort);
    }

    @Bean
    public LogarUsuarioInputPort logarUsuarioImpl(LogarUsuarioOutputPort logarUsuarioOutputPort, BuscarUsuarioOutputPort buscarUsuarioOutputPort, VerificarUsuarioOutputPort verificarUsuarioOutputPort, AuthenticationOutputPort authenticationOutputPort, TokenServiceOutputPort tokenServiceOutputPort) {
        return new LogarUsuarioUseCase(logarUsuarioOutputPort, buscarUsuarioOutputPort, verificarUsuarioOutputPort, authenticationOutputPort, tokenServiceOutputPort);
    }
}

package com.api.odontocloud.infrastructure.config;

import com.api.odontocloud.application.core.usecase.LogarUsuarioUseCase;
import com.api.odontocloud.application.core.usecase.RegistrarUsuarioUseCase;
import com.api.odontocloud.application.core.validation.usuario.UsuarioValidation;
import com.api.odontocloud.application.ports.in.LogarUsuarioInputPort;
import com.api.odontocloud.application.ports.in.RegistrarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeansConfig {

    @Bean
    public RegistrarUsuarioInputPort registrarUsuarioImpl(
            RegistrarUsuarioOutputPort registrarUsuarioOutputPort,
            VerificarUsuarioOutputPort verificarUsuarioOutputPort,
            SalvarUsuarioOutputPort salvarUsuarioOutputPort,
            CriptografarSenhaOutputPort criptografarSenhaOutputPort,
            BuscarUsuarioOutputPort buscarUsuarioOutputPort,
            List<UsuarioValidation> usuarioValidation) {

        return new RegistrarUsuarioUseCase(
                registrarUsuarioOutputPort,
                verificarUsuarioOutputPort,
                salvarUsuarioOutputPort,
                criptografarSenhaOutputPort,
                buscarUsuarioOutputPort,
                usuarioValidation);
    }

    @Bean
    public LogarUsuarioInputPort logarUsuarioImpl(
            LogarUsuarioOutputPort logarUsuarioOutputPort,
            BuscarUsuarioOutputPort buscarUsuarioOutputPort,
            VerificarUsuarioOutputPort verificarUsuarioOutputPort,
            AuthenticationOutputPort authenticationOutputPort,
            TokenServiceOutputPort tokenServiceOutputPort) {

        return new LogarUsuarioUseCase(
                logarUsuarioOutputPort,
                buscarUsuarioOutputPort,
                verificarUsuarioOutputPort,
                authenticationOutputPort,
                tokenServiceOutputPort);
    }
}

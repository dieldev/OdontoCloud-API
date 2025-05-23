package com.api.odontocloud.infrastructure.config;

import com.api.odontocloud.application.core.usecase.*;
import com.api.odontocloud.application.core.validation.usuario.UsuarioValidation;
import com.api.odontocloud.application.ports.in.*;
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

    @Bean
    public AtualizarUsuarioInputPort atualizarUsuarioImpl(
            AtualizarUsuarioOutputPort atualizarUsuarioOutputPort,
            VerificarUsuarioOutputPort verificarUsuarioOutputPort,
            CriptografarSenhaOutputPort criptografarSenhaOutputPort,
            List<UsuarioValidation> usuarioValidation,
            BuscarUsuarioOutputPort buscarUsuarioOutputPort) {

        return new AtualizarUsuarioUseCase(
                atualizarUsuarioOutputPort,
                verificarUsuarioOutputPort,
                criptografarSenhaOutputPort,
                usuarioValidation,
                buscarUsuarioOutputPort);
    }

    @Bean
    public GetAllPacientesInputPort getAllPacientesImpl(
            BuscarPacienteOutputPort buscarPacienteOutputPort) {

        return new GetAllPacientesUseCase(buscarPacienteOutputPort);
    }

    @Bean
    public GetPacienteByIdInputPort getPacienteByIdImpl(
            BuscarPacienteOutputPort buscarPacienteOutputPort) {

        return new GetPacienteByIdUseCase(buscarPacienteOutputPort);
    }

    @Bean
    public NovoPacienteInputPort novoPacienteImpl(
            SalvarPacienteOutputPort salvarPacienteOutputPort) {

        return new NovoPacienteUseCase(salvarPacienteOutputPort);
    }

    @Bean
    public AtualizarPacienteInputPort atualizarPacienteImpl(
            BuscarPacienteOutputPort buscarPacienteOutputPort) {

        return new AtualizarPacienteUseCase(buscarPacienteOutputPort);
    }
}

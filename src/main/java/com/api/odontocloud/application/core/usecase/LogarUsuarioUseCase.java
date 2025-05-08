package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.LoginResponseDTO;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.ports.in.LogarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.*;

public class LogarUsuarioUseCase implements LogarUsuarioInputPort {

    private final LogarUsuarioOutputPort logarUsuarioOutputPort;
    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;
    private final VerificarUsuarioOutputPort verificarUsuarioOutputPort;
    private final AuthenticationOutputPort authenticationOutputPort;
    private final TokenServiceOutputPort tokenServiceOutputPort;

    public LogarUsuarioUseCase(LogarUsuarioOutputPort logarUsuarioOutputPort, BuscarUsuarioOutputPort buscarUsuarioOutputPort, VerificarUsuarioOutputPort verificarUsuarioOutputPort, AuthenticationOutputPort authenticationOutputPort, TokenServiceOutputPort tokenServiceOutputPort) {
        this.logarUsuarioOutputPort = logarUsuarioOutputPort;
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
        this.verificarUsuarioOutputPort = verificarUsuarioOutputPort;
        this.authenticationOutputPort = authenticationOutputPort;
        this.tokenServiceOutputPort = tokenServiceOutputPort;
    }

    @Override
    public LoginResponseDTO execute(LoginRequestDTO loginRequestDTO) {
        if (!verificarUsuarioOutputPort.existsByLogin(loginRequestDTO.login())) {
            throw new ValidacaoException("Usuário não encontrado!");
        }

        authenticationOutputPort.authenticate(loginRequestDTO.login(), loginRequestDTO.password());

        return logarUsuarioOutputPort.execute(tokenServiceOutputPort.gerarToken(buscarUsuarioOutputPort.findByLogin(loginRequestDTO.login())));
    }
}
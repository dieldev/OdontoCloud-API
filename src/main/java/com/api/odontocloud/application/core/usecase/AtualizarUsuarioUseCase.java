package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.auth.UpdateUserResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.core.validation.usuario.UsuarioValidation;
import com.api.odontocloud.application.ports.in.AtualizarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.*;

import java.util.List;

public class AtualizarUsuarioUseCase implements AtualizarUsuarioInputPort {

    private final List<UsuarioValidation> validadores;
    private final AtualizarUsuarioOutputPort atualizarUsuarioOutputPort;
    private final VerificarUsuarioOutputPort verificarUsuarioOutputPort;
    private final CriptografarSenhaOutputPort criptografarSenhaOutputPort;
    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;

    public AtualizarUsuarioUseCase(
            AtualizarUsuarioOutputPort atualizarUsuarioOutputPort,
            VerificarUsuarioOutputPort verificarUsuarioOutputPort,
            CriptografarSenhaOutputPort criptografarSenhaOutputPort,
            List< UsuarioValidation > validadores,
            BuscarUsuarioOutputPort buscarUsuarioOutputPort
    ) {

        this.atualizarUsuarioOutputPort = atualizarUsuarioOutputPort;
        this.verificarUsuarioOutputPort = verificarUsuarioOutputPort;
        this.criptografarSenhaOutputPort = criptografarSenhaOutputPort;
        this.validadores = validadores;
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
    }

    @Override
    public UpdateUserResponseDTO execute(Usuario usuario, Long id) {
        if (verificarUsuarioOutputPort.existsByLogin(usuario.getLogin())) {
            throw new ValidacaoException("Login existente!");
        }

        try {
            validadores.forEach(v -> v.validar(usuario));
        } catch (ValidacaoException e) {
            throw new ValidacaoException("Não foi possível atualizar o usuário: " + e.getMessage());
        }

        usuario.setPassword(criptografarSenhaOutputPort.execute(usuario.getPassword()));
        return atualizarUsuarioOutputPort.execute(usuario, id);
    }
}

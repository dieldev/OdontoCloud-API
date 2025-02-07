package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.core.validation.usuario.UsuarioValidation;
import com.api.odontocloud.application.ports.in.RegistrarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.*;

import java.util.List;

public class RegistrarUsuarioUseCase implements RegistrarUsuarioInputPort {

    private final List<UsuarioValidation> validadores;
    private final RegistrarUsuarioOutputPort registrarUsuarioOutputPort;
    private final VerificarUsuarioOutputPort verificarUsuarioOutputPort;
    private final SalvarUsuarioOutputPort salvarUsuarioOutputPort;
    private final CriptografarSenhaOutputPort criptografarSenhaOutputPort;
    private final BuscarUsuarioOutputPort buscarUsuarioOutputPort;

    public RegistrarUsuarioUseCase(RegistrarUsuarioOutputPort registrarUsuarioOutputPort, VerificarUsuarioOutputPort verificarUsuarioOutputPort, SalvarUsuarioOutputPort salvarUsuarioOutputPort, CriptografarSenhaOutputPort criptografarSenhaOutputPort, BuscarUsuarioOutputPort buscarUsuarioOutputPort, List<UsuarioValidation> validadores) {
        this.registrarUsuarioOutputPort = registrarUsuarioOutputPort;
        this.verificarUsuarioOutputPort = verificarUsuarioOutputPort;
        this.salvarUsuarioOutputPort = salvarUsuarioOutputPort;
        this.criptografarSenhaOutputPort = criptografarSenhaOutputPort;
        this.buscarUsuarioOutputPort = buscarUsuarioOutputPort;
        this.validadores = validadores;
    }

    @Override
    public RegisterResponseDTO execute(Usuario usuario) {
        if (verificarUsuarioOutputPort.existsByLogin(usuario.getLogin())) {
            throw new ValidacaoException("Usuário existente!");
        }

        // Novo usuário com a senha criptografada
        Usuario novoUsuario = new Usuario(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getLogin(),
                criptografarSenhaOutputPort.execute(usuario.getPassword()),
                usuario.isAtivo(),
                usuario.getUsuarioRole(),
                usuario.getDetalhesUsuario()
        );

        try {
            validadores.forEach(v -> v.validar(novoUsuario));
            salvarUsuarioOutputPort.execute(novoUsuario);
        } catch (ValidacaoException e) {
            throw new ValidacaoException("Não foi possível salvar o usuário: " + e.getMessage());
        }

        Usuario novoUsuarioComId = buscarUsuarioOutputPort.findByLogin(novoUsuario.getLogin());

        return registrarUsuarioOutputPort.execute(novoUsuarioComId);
    }
}

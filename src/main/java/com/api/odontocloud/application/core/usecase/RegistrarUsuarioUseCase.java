package com.api.odontocloud.application.core.usecase;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.ports.in.RegistrarUsuarioInputPort;
import com.api.odontocloud.application.ports.out.CriptografarSenhaOutputPort;
import com.api.odontocloud.application.ports.out.RegistrarUsuarioOutputPort;
import com.api.odontocloud.application.ports.out.SalvarUsuarioOutputPort;
import com.api.odontocloud.application.ports.out.VerificarUsuarioOutputPort;

public class RegistrarUsuarioUseCase implements RegistrarUsuarioInputPort {

    private final RegistrarUsuarioOutputPort registrarUsuarioOutputPort;
    private final VerificarUsuarioOutputPort verificarUsuarioOutputPort;
    private final SalvarUsuarioOutputPort salvarUsuarioOutputPort;
    private final CriptografarSenhaOutputPort criptografarSenhaOutputPort;

    public RegistrarUsuarioUseCase(RegistrarUsuarioOutputPort registrarUsuarioOutputPort, VerificarUsuarioOutputPort verificarUsuarioOutputPort, SalvarUsuarioOutputPort salvarUsuarioOutputPort, CriptografarSenhaOutputPort criptografarSenhaOutputPort) {
        this.registrarUsuarioOutputPort = registrarUsuarioOutputPort;
        this.verificarUsuarioOutputPort = verificarUsuarioOutputPort;
        this.salvarUsuarioOutputPort = salvarUsuarioOutputPort;
        this.criptografarSenhaOutputPort = criptografarSenhaOutputPort;
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
                usuario.getUsuarioRole()
        );

        try {
            salvarUsuarioOutputPort.execute(novoUsuario);
        } catch (ValidacaoException e) {
            throw new ValidacaoException("Não foi possível salvar o usuário: " + e.getMessage());
        }

        return registrarUsuarioOutputPort.execute(novoUsuario);
    }
}

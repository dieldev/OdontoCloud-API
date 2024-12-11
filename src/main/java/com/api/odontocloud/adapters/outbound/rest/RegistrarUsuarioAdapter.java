package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.ports.out.RegistrarUsuarioOutputPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegistrarUsuarioAdapter implements RegistrarUsuarioOutputPort {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;

    public RegistrarUsuarioAdapter(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public RegisterResponseDTO execute(Usuario usuario) {
        if (usuarioRepository.existsByLogin(usuario.getLogin())) {
            throw new ValidacaoException("O usuário já está registrado!");
        }

        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        Usuario novoUsuario = new Usuario(usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getTelefone(), usuario.getLogin(), senhaCriptografada, usuario.isAtivo(), usuario.getUsuarioRole());
        System.out.println("novoUsuario: " + novoUsuario.toString());

        var usuarioConvertido = usuarioMapper.fromDomainToEntity((novoUsuario));
        System.out.println("usuarioConvertido: " + usuarioConvertido.toString());
        try {
            usuarioRepository.save(usuarioConvertido);
        } catch (ValidacaoException exception) {
            throw new ValidacaoException("Não foi possível salvar o usuário: " + exception.getMessage());
        }

        return usuarioMapper.fromUsuariotoDtoRegisterResponse(novoUsuario);
    }
}

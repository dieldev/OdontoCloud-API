package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import com.api.odontocloud.application.ports.out.VerificarUsuarioOutputPort;
import org.springframework.stereotype.Component;

@Component
public class VerificarUsuarioAdapter implements VerificarUsuarioOutputPort {

    private final UsuarioRepository usuarioRepository;

    public VerificarUsuarioAdapter(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean existsByLogin(String login) {
        return usuarioRepository.existsByLogin(login);
    }

    public boolean existsById(Long id) {
        return usuarioRepository.existsById(id);
    }
}

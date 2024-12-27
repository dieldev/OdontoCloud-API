package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.ports.out.SalvarUsuarioOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SalvarUsuarioAdapter implements SalvarUsuarioOutputPort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public SalvarUsuarioAdapter(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public void execute(Usuario usuario) {
        usuarioRepository.save(usuarioMapper.fromDomainToEntity(usuario));
    }
}

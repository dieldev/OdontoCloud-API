package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.adapters.outbound.entity.JpaUsuarioEntity;
import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.ports.out.BuscarUsuarioOutputPort;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioAdapter implements BuscarUsuarioOutputPort {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public BuscarUsuarioAdapter(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario findByLogin(String login) {
        System.out.println("");
        System.out.println("");
        JpaUsuarioEntity usuarioTeste = usuarioRepository.findByLogin(login).get();
        System.out.println("usuarioTeste: " + usuarioTeste);
        System.out.println("detalhesUsuarioTeste: " + usuarioTeste.getDetalhes());
        System.out.println("");
        System.out.println("");
        return usuarioMapper.fromEntityToDomain(usuarioRepository.findByLogin(login).get());
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioMapper.fromEntityToDomain(usuarioRepository.findById(id).get());
    }
}

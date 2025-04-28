package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.adapters.outbound.entity.JpaDetalhesUsuarioEntity;
import com.api.odontocloud.adapters.outbound.entity.JpaUsuarioEntity;
import com.api.odontocloud.adapters.outbound.repository.DetalhesUsuarioRepository;
import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.ports.out.SalvarUsuarioOutputPort;
import org.springframework.stereotype.Component;

@Component
public class SalvarUsuarioAdapter implements SalvarUsuarioOutputPort {

    private final UsuarioRepository usuarioRepository;
    private final DetalhesUsuarioRepository detalhesUsuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public SalvarUsuarioAdapter(UsuarioRepository usuarioRepository, DetalhesUsuarioRepository detalhesUsuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.detalhesUsuarioRepository = detalhesUsuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public void execute(Usuario usuario) {
        JpaUsuarioEntity usuarioEntity = usuarioMapper.toJpaEntity(usuario);
        JpaDetalhesUsuarioEntity detalhesEntity = usuarioMapper.toJpaEntity(usuario.getDetalhesUsuario());
        detalhesEntity.setUsuario(usuarioEntity);
        usuarioEntity.setDetalhes(detalhesEntity);
        usuarioRepository.save(usuarioEntity);
    }
}

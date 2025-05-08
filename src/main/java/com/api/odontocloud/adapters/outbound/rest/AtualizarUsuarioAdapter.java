package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.inbound.dto.auth.UpdateUserResponseDTO;
import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.adapters.outbound.entity.JpaDetalhesUsuarioEntity;
import com.api.odontocloud.adapters.outbound.entity.JpaUsuarioEntity;
import com.api.odontocloud.adapters.outbound.repository.DetalhesUsuarioRepository;
import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.ports.out.AtualizarUsuarioOutputPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class AtualizarUsuarioAdapter implements AtualizarUsuarioOutputPort {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;
    private final DetalhesUsuarioRepository detalhesUsuarioRepository;

    public AtualizarUsuarioAdapter(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository, DetalhesUsuarioRepository detalhesUsuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
        this.detalhesUsuarioRepository = detalhesUsuarioRepository;
    }

    @Override
    public UpdateUserResponseDTO execute(Usuario usuario, Long id) {
        Optional<JpaUsuarioEntity> novoUsuario = usuarioRepository.findById(id);

        if (novoUsuario.isPresent()) {
            JpaUsuarioEntity entidade = novoUsuario.get();

            if (usuario.getLogin() != null) entidade.setLogin(usuario.getLogin());
            if (usuario.getPassword() != null) entidade.setPassword(usuario.getPassword());
            if (usuario.getNome() != null) entidade.setNome(usuario.getNome());
            if (usuario.getSobrenome() != null) entidade.setSobrenome(usuario.getSobrenome());
            if (usuario.getTelefone() != null) entidade.setTelefone(usuario.getTelefone());
            if (usuario.getUsuarioRole() != null) entidade.setRole(usuario.getUsuarioRole());

            usuarioRepository.save(entidade);

            Optional<JpaDetalhesUsuarioEntity> detalhesUsuario = detalhesUsuarioRepository.findById(entidade.getDetalhes().getId());
            if (detalhesUsuario.isPresent()) {
                JpaDetalhesUsuarioEntity detalhes = detalhesUsuario.get();

                if (usuario.getDetalhesUsuario().getCro() != null)
                    detalhes.setCro(usuario.getDetalhesUsuario().getCro());

                if (usuario.getDetalhesUsuario().getDataCadastro() != null)
                    detalhes.setDataCadastro(usuario.getDetalhesUsuario().getDataCadastro());

                detalhes.setDataAtualizacao(LocalDateTime.now());

                detalhesUsuarioRepository.save(detalhes);
            }
        }


        return usuarioMapper.fromUsuariotoDtoUpdateResponse(usuarioMapper.fromEntityToDomain(novoUsuario.get()));
    }
}
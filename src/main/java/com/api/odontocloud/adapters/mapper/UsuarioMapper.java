package com.api.odontocloud.adapters.mapper;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.RegisterRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.RegisterRespondeDetalhesDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.adapters.outbound.entity.JpaDetalhesUsuarioEntity;
import com.api.odontocloud.adapters.outbound.entity.JpaUsuarioEntity;
import com.api.odontocloud.adapters.outbound.repository.DetalhesUsuarioRepository;
import com.api.odontocloud.application.core.domain.DetalhesUsuario;
import com.api.odontocloud.application.core.domain.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UsuarioMapper {

    private DetalhesUsuarioRepository detalhesUsuarioRepository;

    // Converte RegisterRequestDTO para Usuario
    public Usuario registerDtoToDomain(RegisterRequestDTO registerRequestDTO) {

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(registerRequestDTO.nome());
        novoUsuario.setSobrenome(registerRequestDTO.sobrenome());
        novoUsuario.setTelefone(registerRequestDTO.telefone());
        novoUsuario.setLogin(registerRequestDTO.login());
        novoUsuario.setPassword(registerRequestDTO.password());
        novoUsuario.setAtivo(true);
        novoUsuario.setUsuarioRole(registerRequestDTO.usuarioRole());

        DetalhesUsuario detalhesUsuario = new DetalhesUsuario();
        detalhesUsuario.setDataCadastro(LocalDateTime.now());

        switch (registerRequestDTO.usuarioRole()) {
            case ADMIN:
                break;
            case DENTISTA:
                detalhesUsuario.setCro(registerRequestDTO.cro());
                break;
            case RECEPCIONISTA:
                break;
            case USER:
                break;
        }

        novoUsuario.setDetalhesUsuario(detalhesUsuario);

        return novoUsuario;
    }

    // Converte LoginRequestDTO para Usuario
    public Usuario loginToDomain(LoginRequestDTO loginRequestDTO) {
        return new Usuario(
                loginRequestDTO.getLogin(),
                loginRequestDTO.getPassword());
    }

    // Converte Usuario para LoginRequestDTO
    public LoginRequestDTO toDtoLoginRequest(Usuario usuario) {
        return new LoginRequestDTO(usuario.getLogin(), usuario.getPassword());
    }

    // Converte JpaUsuarioEntity para Usuario
    public Usuario fromEntityToDomain(JpaUsuarioEntity jpaUsuarioEntity) {
        if (jpaUsuarioEntity.getDetalhes().getId() != null) {
            return new Usuario(
                    jpaUsuarioEntity.getId(),
                    jpaUsuarioEntity.getNome(),
                    jpaUsuarioEntity.getSobrenome(),
                    jpaUsuarioEntity.getTelefone(),
                    jpaUsuarioEntity.getLogin(),
                    jpaUsuarioEntity.getPassword(),
                    jpaUsuarioEntity.isAtivo(),
                    jpaUsuarioEntity.getRole(),
                    fromEntitytoDomain(jpaUsuarioEntity.getDetalhes()));
        }
        return new Usuario(
                jpaUsuarioEntity.getId(),
                jpaUsuarioEntity.getNome(),
                jpaUsuarioEntity.getSobrenome(),
                jpaUsuarioEntity.getTelefone(),
                jpaUsuarioEntity.getLogin(),
                jpaUsuarioEntity.getPassword(),
                jpaUsuarioEntity.isAtivo(),
                jpaUsuarioEntity.getRole());
    }

    // Converte Usuario para RegisterResponseDTO
    public RegisterResponseDTO fromUsuariotoDtoRegisterResponse(Usuario usuario) {
        RegisterRespondeDetalhesDTO detalhesUsuario = new RegisterRespondeDetalhesDTO(usuario.getDetalhesUsuario().getId(), usuario.getDetalhesUsuario().getCro(), usuario.getDetalhesUsuario().getDataCadastro());
        return new RegisterResponseDTO(
                usuario.getId() == null ? null : usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getLogin(),
                usuario.getPassword(),
                usuario.isAtivo(),
                usuario.getUsuarioRole(),

                detalhesUsuario);
    }

    // Converte Usuario para JpaUsuarioEntity
    public JpaUsuarioEntity toJpaEntity(Usuario usuario) {
        JpaUsuarioEntity usuarioEntity = new JpaUsuarioEntity();
        if (usuario.getId() != null) {
            usuarioEntity.setId(usuario.getId());
        }
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setSobrenome(usuario.getSobrenome());
        usuarioEntity.setTelefone(usuario.getTelefone());
        usuarioEntity.setLogin(usuario.getLogin());
        usuarioEntity.setPassword(usuario.getPassword());
        usuarioEntity.setAtivo(usuario.isAtivo());
        usuarioEntity.setRole(usuario.getUsuarioRole());
        if (usuario.getDetalhesUsuario().getId() != null) {
            usuarioEntity.setDetalhes(toJpaEntity(usuario.getDetalhesUsuario()));
            return usuarioEntity;
        }

        return usuarioEntity;
    }

    // Converte DetalhesUsuario para JpaDetalhesUsuarioEntity
    public JpaDetalhesUsuarioEntity toJpaEntity(DetalhesUsuario detalhesUsuario) {
        JpaDetalhesUsuarioEntity detalhesEntity = new JpaDetalhesUsuarioEntity();
        if (detalhesUsuario.getId() != null) {
            detalhesEntity.setId(detalhesUsuario.getId());
        }
        detalhesEntity.setCro(detalhesUsuario.getCro());
        detalhesEntity.setDataCadastro(detalhesUsuario.getDataCadastro());
        detalhesEntity.setDataAtualizacao(detalhesUsuario.getDataAtualizacao());
        detalhesEntity.setDataBloqueio(detalhesUsuario.getDataBloqueio());

        return detalhesEntity;
    }

    // Converte JpaDetalhesUsuarioEntity para DetalhesUsuario
    public DetalhesUsuario fromEntitytoDomain(JpaDetalhesUsuarioEntity jpaDetalhesUsuarioEntity) {
        return new DetalhesUsuario(
                jpaDetalhesUsuarioEntity.getId(),
                null,
                jpaDetalhesUsuarioEntity.getCro(),
                jpaDetalhesUsuarioEntity.getDataCadastro(),
                jpaDetalhesUsuarioEntity.getDataAtualizacao(),
                jpaDetalhesUsuarioEntity.getDataBloqueio()
        );
    }
}
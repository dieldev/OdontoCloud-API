package com.api.odontocloud.adapters.mapper;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.RegisterRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.RegisterResponseDTO;
import com.api.odontocloud.adapters.outbound.entity.UsuarioEntity;
import com.api.odontocloud.application.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    // Converte RegisterRequestDTO para Usuario
    public Usuario registerDtoToDomain(RegisterRequestDTO registerRequestDTO) {
        return new Usuario(
                null,
                registerRequestDTO.nome(),
                registerRequestDTO.sobrenome(),
                registerRequestDTO.telefone(),
                registerRequestDTO.login(),
                registerRequestDTO.password(),
                true,
                registerRequestDTO.usuarioRole());
    }

    // Converte Usuario para RegisterRequestDTO
    public RegisterRequestDTO toDtoRegisterRequest(Usuario usuario) {
        return new RegisterRequestDTO(
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getLogin(),
                usuario.getPassword(),
                usuario.getUsuarioRole());
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

    // Converte Usuario para UsuarioEntity
    public UsuarioEntity fromDomainToEntity(Usuario usuario) {
        return new UsuarioEntity(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getLogin(),
                usuario.getPassword(),
                usuario.isAtivo(),
                usuario.getUsuarioRole());
    }

    // Converte UsuarioEntity para Usuario
    public Usuario fromEntityToDomain(UsuarioEntity usuarioEntity) {
        return new Usuario(usuarioEntity.getId(),
                usuarioEntity.getNome(),
                usuarioEntity.getSobrenome(),
                usuarioEntity.getTelefone(),
                usuarioEntity.getLogin(),
                usuarioEntity.getPassword(),
                usuarioEntity.isAtivo(),
                usuarioEntity.getRole());
    }

    // Converte Usuario para RegisterResponseDTO
    public RegisterResponseDTO fromUsuariotoDtoRegisterResponse(Usuario usuario) {
        return new RegisterResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getSobrenome(),
                usuario.getTelefone(),
                usuario.getLogin(),
                usuario.getPassword(),
                usuario.isAtivo(),
                usuario.getUsuarioRole());
    }

    // Converte RegisterRequestDTO para RegisterResponseDTO
    public RegisterResponseDTO fromRequestToResponseRegister(RegisterRequestDTO registerRequestDTO) {
        return new RegisterResponseDTO(
                null,
                registerRequestDTO.nome(),
                registerRequestDTO.sobrenome(),
                registerRequestDTO.telefone(),
                registerRequestDTO.login(),
                registerRequestDTO.password(),
                true,
                registerRequestDTO.usuarioRole());
    }
}

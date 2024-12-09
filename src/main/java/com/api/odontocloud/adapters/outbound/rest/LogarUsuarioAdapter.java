package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.inbound.dto.auth.LoginRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.auth.LoginResponseDTO;
import com.api.odontocloud.adapters.outbound.entity.UsuarioEntity;
import com.api.odontocloud.adapters.outbound.repository.UsuarioRepository;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.ports.out.LogarUsuarioOutputPort;
import com.api.odontocloud.infrastructure.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LogarUsuarioAdapter implements LogarUsuarioOutputPort {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public LogarUsuarioAdapter(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public LoginResponseDTO execute(LoginRequestDTO loginRequestDTO) {

        var loginRecebido = usuarioRepository.findByLogin(loginRequestDTO.getLogin());

        if (!loginRecebido.isPresent()) {
            throw new ValidacaoException("Usuário não encontrado!");
        }

        var authenticationToken = new UsernamePasswordAuthenticationToken(loginRequestDTO.getLogin(), loginRequestDTO.getPassword());
        var authentication = authenticationManager.authenticate(authenticationToken);

        var usuarioEncontrado = usuarioRepository.findByLogin(loginRecebido.get().getLogin());

        var usuarioEntity = usuarioEncontrado.get();
        System.out.println("getPrincipal: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        System.out.println("getAuthorities: " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        System.out.println("getDetails: " + SecurityContextHolder.getContext().getAuthentication().getDetails());
        System.out.println("getCredentials: " + SecurityContextHolder.getContext().getAuthentication().getCredentials());

        return new LoginResponseDTO(tokenService.gerarToken(usuarioEntity));
    }
}

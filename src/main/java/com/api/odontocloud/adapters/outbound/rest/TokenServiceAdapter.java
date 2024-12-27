package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.adapters.mapper.UsuarioMapper;
import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.ports.out.TokenServiceOutputPort;
import com.api.odontocloud.infrastructure.security.TokenService;
import org.springframework.stereotype.Component;

@Component
public class TokenServiceAdapter implements TokenServiceOutputPort {

    private final TokenService tokenService;
    private final UsuarioMapper usuarioMapper;

    public TokenServiceAdapter(TokenService tokenService, UsuarioMapper usuarioMapper) {
        this.tokenService = tokenService;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public String gerarToken(Usuario usuario) {
        return tokenService.gerarToken(usuarioMapper.fromDomainToEntity(usuario));
    }

    @Override
    public String getSubject(String tokenJWT) {
        return tokenService.getSubject(tokenJWT);
    }
}

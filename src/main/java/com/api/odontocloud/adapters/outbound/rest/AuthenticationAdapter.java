package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.application.core.exception.ValidacaoException;
import com.api.odontocloud.application.ports.out.AuthenticationOutputPort;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationAdapter implements AuthenticationOutputPort {

    private final AuthenticationManager authenticationManager;

    public AuthenticationAdapter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void authenticate(String login, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
        } catch (AuthenticationException e) {
            throw new ValidacaoException("Ocorreu um problema ao tentar se autenticar: " + e.getMessage());
        }

    }
}
package com.api.odontocloud.adapters.outbound.rest;

import com.api.odontocloud.application.ports.out.CriptografarSenhaOutputPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CriptografarSenhaAdapter implements CriptografarSenhaOutputPort {

    private final PasswordEncoder passwordEncoder;

    public CriptografarSenhaAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String execute(String senha) {
        return passwordEncoder.encode(senha);
    }
}

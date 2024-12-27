package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.application.core.domain.Usuario;

public interface TokenServiceOutputPort {

    String gerarToken(Usuario usuario);

    String getSubject(String tokenJWT);
}

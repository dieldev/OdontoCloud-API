package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.application.core.domain.Usuario;

public interface BuscarUsuarioOutputPort {

    Usuario findByLogin(String login);

    Usuario findById(Long id);
}

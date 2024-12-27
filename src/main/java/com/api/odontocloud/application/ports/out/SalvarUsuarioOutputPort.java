package com.api.odontocloud.application.ports.out;

import com.api.odontocloud.application.core.domain.Usuario;

public interface SalvarUsuarioOutputPort {

    void execute(Usuario usuario);
}

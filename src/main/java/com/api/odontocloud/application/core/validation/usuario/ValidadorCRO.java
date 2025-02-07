package com.api.odontocloud.application.core.validation.usuario;

import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component("UsuarioValidation")
public class ValidadorCRO implements UsuarioValidation {

    @Override
    public void validar(Usuario usuario) {
        if (usuario.getUsuarioRole().equals("DENTISTA") && usuario.getDetalhesUsuario().getCro().isEmpty()) {
            throw new ValidacaoException("O campo CRO é obrigatório para DENTISTA!");
        }
    }
}

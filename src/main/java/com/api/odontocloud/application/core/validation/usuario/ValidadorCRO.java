package com.api.odontocloud.application.core.validation.usuario;

import com.api.odontocloud.application.core.domain.Usuario;
import com.api.odontocloud.application.core.domain.UsuarioRole;
import com.api.odontocloud.application.core.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component("UsuarioValidation")
public class ValidadorCRO implements UsuarioValidation {

    @Override
    public void validar(Usuario usuario) {
        if (usuario.getUsuarioRole() == UsuarioRole.DENTISTA && usuario.getDetalhesUsuario().getCro() == null) {
            throw new ValidacaoException("O campo CRO é obrigatório para DENTISTA!");
        }
    }
}

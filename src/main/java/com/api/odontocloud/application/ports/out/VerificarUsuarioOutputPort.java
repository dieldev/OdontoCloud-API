package com.api.odontocloud.application.ports.out;

public interface VerificarUsuarioOutputPort {

    boolean existsByLogin(String login);
}

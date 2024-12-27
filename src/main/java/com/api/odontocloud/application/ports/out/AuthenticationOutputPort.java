package com.api.odontocloud.application.ports.out;

public interface AuthenticationOutputPort {

    void authenticate(String login, String password);
}

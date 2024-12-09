package com.api.odontocloud.adapters.inbound.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {

    @NotBlank(message = "O campo login é obrigatório")
    private String login;
    @NotBlank(message = "O campo password é obrigatório")
    private String password;

    public LoginRequestDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

package com.api.odontocloud.adapters.inbound.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO (

        @NotBlank(message = "O campo login é obrigatório")
        String login,

        @NotBlank(message = "O campo password é obrigatório")
        String password){
}

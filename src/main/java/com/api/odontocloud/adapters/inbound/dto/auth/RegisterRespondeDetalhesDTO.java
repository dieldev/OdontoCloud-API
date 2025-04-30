package com.api.odontocloud.adapters.inbound.dto.auth;

import java.time.LocalDateTime;

public record RegisterRespondeDetalhesDTO(
        Integer id,
        String cro,
        LocalDateTime dataCadastro) {
}

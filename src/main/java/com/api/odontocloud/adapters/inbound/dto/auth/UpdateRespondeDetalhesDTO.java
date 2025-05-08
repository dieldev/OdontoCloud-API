package com.api.odontocloud.adapters.inbound.dto.auth;

import java.time.LocalDateTime;

public record UpdateRespondeDetalhesDTO(
        Integer id,
        String cro,
        LocalDateTime dataAtualizacao,
        LocalDateTime dataCadastro) {
}

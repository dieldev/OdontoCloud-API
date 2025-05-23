package com.api.odontocloud.adapters.inbound.dto.paciente;

import java.time.LocalDateTime;

public record AtualizaPacienteResponseDTO(
        String nome,
        String sobrenome,
        String telefone,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao,
        LocalDateTime dataBloqueio,
        String email,
        String logradouro,
        String bairro,
        String cep,
        String numero,
        String complemento,
        String cidade,
        String uf
) {
}

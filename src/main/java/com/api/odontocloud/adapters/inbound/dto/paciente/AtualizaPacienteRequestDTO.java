package com.api.odontocloud.adapters.inbound.dto.paciente;

public record AtualizaPacienteRequestDTO(
        String nome,
        String sobrenome,
        String telefone,
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

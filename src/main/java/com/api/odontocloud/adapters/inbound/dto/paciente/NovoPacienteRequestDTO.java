package com.api.odontocloud.adapters.inbound.dto.paciente;

import jakarta.validation.constraints.NotBlank;

public record NovoPacienteRequestDTO(

        @NotBlank(message = "O campo nome é obrigatório")
        String nome,

        @NotBlank(message = "O campo sobrenome é obrigatório")
        String sobrenome,

        @NotBlank(message = "O campo telefone é obrigatório")
        String telefone,

        @NotBlank(message = "O campo email é obrigatório")
        String email,

        @NotBlank(message = "O campo logradouro é obrigatório")
        String logradouro,

        @NotBlank(message = "O campo bairro é obrigatório")
        String bairro,

        @NotBlank(message = "O campo CEP é obrigatório")
        String cep,

        @NotBlank(message = "O campo número é obrigatório")
        String numero,

        @NotBlank(message = "O campo complemento é obrigatório")
        String complemento,

        @NotBlank(message = "O campo cidade é obrigatório")
        String cidade,

        @NotBlank(message = "O campo UF é obrigatório")
        String uf

) {
}

package com.api.odontocloud.adapters.mapper;

import com.api.odontocloud.adapters.inbound.dto.paciente.AtualizaPacienteRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.paciente.NovoPacienteRequestDTO;
import com.api.odontocloud.adapters.inbound.dto.paciente.PacienteResponseDTO;
import com.api.odontocloud.adapters.outbound.entity.JpaPacienteEntity;
import com.api.odontocloud.application.core.domain.Paciente;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PacienteMapper {

    public PacienteResponseDTO toResponseDTO(JpaPacienteEntity jpaPaciente) {
        return new PacienteResponseDTO(
                jpaPaciente.getId() == null ? null : jpaPaciente.getId(),
                jpaPaciente.getNome(),
                jpaPaciente.getSobrenome(),
                jpaPaciente.getTelefone(),
                jpaPaciente.getDataCadastro(),
                jpaPaciente.getDataAtualizacao(),
                jpaPaciente.getDataBloqueio(),
                jpaPaciente.getEmail(),
                jpaPaciente.getLogradouro(),
                jpaPaciente.getBairro(),
                jpaPaciente.getCep(),
                jpaPaciente.getNumero(),
                jpaPaciente.getComplemento(),
                jpaPaciente.getCidade(),
                jpaPaciente.getUf());
    }

    public Paciente toDomain(JpaPacienteEntity jpaPaciente) {
        return new Paciente(
                jpaPaciente.getId(),
                jpaPaciente.getNome(),
                jpaPaciente.getSobrenome(),
                jpaPaciente.getTelefone(),
                jpaPaciente.getDataCadastro(),
                jpaPaciente.getDataAtualizacao(),
                jpaPaciente.getDataBloqueio(),
                jpaPaciente.getEmail(),
                jpaPaciente.getLogradouro(),
                jpaPaciente.getBairro(),
                jpaPaciente.getCep(),
                jpaPaciente.getNumero(),
                jpaPaciente.getComplemento(),
                jpaPaciente.getCidade(),
                jpaPaciente.getUf());
    }

    public JpaPacienteEntity toEntity(Paciente domain) {
        return new JpaPacienteEntity(
                domain.getId(),
                domain.getNome(),
                domain.getSobrenome(),
                domain.getTelefone(),
                domain.getDataCadastro(),
                domain.getDataAtualizacao(),
                domain.getDataBloqueio(),
                domain.getEmail(),
                domain.getLogradouro(),
                domain.getBairro(),
                domain.getCep(),
                domain.getNumero(),
                domain.getComplemento(),
                domain.getCidade(),
                domain.getUf());
    }

    public Paciente fromNewRequestToDomain(NovoPacienteRequestDTO novoPacienteRequestDTO) {
                return new Paciente(
                null,
                novoPacienteRequestDTO.nome(),
                novoPacienteRequestDTO.sobrenome(),
                novoPacienteRequestDTO.telefone(),
                LocalDateTime.now(),
                null,
                null,
                novoPacienteRequestDTO.email(),
                novoPacienteRequestDTO.logradouro(),
                novoPacienteRequestDTO.bairro(),
                novoPacienteRequestDTO.cep(),
                novoPacienteRequestDTO.numero(),
                novoPacienteRequestDTO.complemento(),
                novoPacienteRequestDTO.cidade(),
                novoPacienteRequestDTO.uf()
        );
    }

    public Paciente fromUpdateRequestToDomain(AtualizaPacienteRequestDTO atualizaPacienteRequestDTO) {
        return new Paciente(
                null,
                atualizaPacienteRequestDTO.nome(),
                atualizaPacienteRequestDTO.sobrenome(),
                atualizaPacienteRequestDTO.telefone(),
                null,
                LocalDateTime.now(),
                null,
                atualizaPacienteRequestDTO.email(),
                atualizaPacienteRequestDTO.logradouro(),
                atualizaPacienteRequestDTO.bairro(),
                atualizaPacienteRequestDTO.cep(),
                atualizaPacienteRequestDTO.numero(),
                atualizaPacienteRequestDTO.complemento(),
                atualizaPacienteRequestDTO.cidade(),
                atualizaPacienteRequestDTO.uf()
        );
    }
}